package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    User registerUser(User user);

    User findByEmail(String email);

    User getById(Long id);

    void delete(Long id);
}


DoctypeService:

package com.example.demo.service;

import com.example.demo.model.DocumentType;

import java.util.List;

public interface DocumentTypeService {
    DocumentType create(DocumentType dt);
    DocumentType getById(Long id);
    List<DocumentType> getAll();
}
Complrule:
package com.example.demo.service;

import com.example.demo.model.ComplianceRule;

import java.util.List;

public interface ComplianceRuleService {
    ComplianceRule create(ComplianceRule rule);
    ComplianceRule getById(Long id);
    List<ComplianceRule> getAll();
}
coplscore:
package com.example.demo.service;

import com.example.demo.model.ComplianceScore;

public interface ComplianceScoreService {
    ComplianceScore evaluateVendor(Long vendorId);
    ComplianceScore getScore(Long vendorId);
}

