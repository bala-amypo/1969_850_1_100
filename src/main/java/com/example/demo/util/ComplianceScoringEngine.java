public double calculateScore(List<DocumentType> required, List<?> uploaded) {
    if (required.isEmpty()) return 100.0;

    double totalWeight = required.stream().mapToDouble(DocumentType::getWeight).sum();
    double obtained = 0.0;

    for (DocumentType dt : required) {
        for (Object obj : uploaded) {

            if (obj instanceof DocumentType
                    && dt.getId().equals(((DocumentType) obj).getId())) {

                obtained += dt.getWeight();
                break;   // ✅ ADD THIS

            } else if (obj instanceof VendorDocument) {

                VendorDocument vd = (VendorDocument) obj;

                if (vd.getDocumentType() != null
                        && vd.getDocumentType().getId().equals(dt.getId())
                        && Boolean.TRUE.equals(vd.getIsValid())) {

                    obtained += dt.getWeight();
                    break;   // ✅ ADD THIS
                }
            }
        }
    }

    return (obtained / totalWeight) * 100.0;
}
