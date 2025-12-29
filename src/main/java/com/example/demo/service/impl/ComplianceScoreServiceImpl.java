@Service
public class ComplianceScoreServiceImpl implements ComplianceScoreService {

    private final VendorRepository vendorRepository;
    private final DocumentTypeRepository documentTypeRepository;
    private final VendorDocumentRepository vendorDocumentRepository;
    private final ComplianceScoreRepository complianceScoreRepository;

    public ComplianceScoreServiceImpl(
            VendorRepository vendorRepository,
            DocumentTypeRepository documentTypeRepository,
            VendorDocumentRepository vendorDocumentRepository,
            ComplianceScoreRepository complianceScoreRepository
    ) {
        this.vendorRepository = vendorRepository;
        this.documentTypeRepository = documentTypeRepository;
        this.vendorDocumentRepository = vendorDocumentRepository;
        this.complianceScoreRepository = complianceScoreRepository;
    }

    @Override
    public ComplianceScore evaluateVendor(Long vendorId) {

        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() ->
                        new com.example.demo.exception.ResourceNotFoundException("Vendor not found"));

        List<DocumentType> requiredTypes =
                documentTypeRepository.findByRequiredTrue();

        if (requiredTypes.isEmpty()) {
            ComplianceScore score = new ComplianceScore();
            score.setVendor(vendor);
            score.setScoreValue(100.0);
            score.setRating("EXCELLENT");
            return complianceScoreRepository.save(score);
        }

        List<VendorDocument> vendorDocs =
                vendorDocumentRepository.findByVendor(vendor);

        int totalWeight = requiredTypes.stream()
                .mapToInt(DocumentType::getWeight)
                .sum();

        int obtainedWeight = 0;

        for (DocumentType dt : requiredTypes) {
            boolean hasValid = vendorDocs.stream().anyMatch(d ->
                    d.getDocumentType().getId().equals(dt.getId()) &&
                    Boolean.TRUE.equals(d.getIsValid())
            );

            if (hasValid) {
                obtainedWeight += dt.getWeight();
            }
        }

        double scoreValue = totalWeight == 0
                ? 100.0
                : (obtainedWeight * 100.0) / totalWeight;

        ComplianceScore score = new ComplianceScore();
        score.setVendor(vendor);
        score.setScoreValue(scoreValue);
        score.setRating(
                new com.example.demo.util.ComplianceScoringEngine()
                        .deriveRating(scoreValue)
        );

        return complianceScoreRepository.save(score);
    }

    @Override
    public ComplianceScore getScore(Long vendorId) {
        return complianceScoreRepository.findByVendor_Id(vendorId)
                .orElseThrow(() ->
                        new com.example.demo.exception.ResourceNotFoundException("Score not found"));
    }
}
