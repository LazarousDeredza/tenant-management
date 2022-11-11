//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.service.propertyManagement;

import com.cicosy.tenant_management.model.propertyManagement.Property;
import com.cicosy.tenant_management.repository.propertyManagement.PropertyRepository;
import java.util.List;
import java.util.Objects;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {
    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public void saveProperty(Property property) {
        this.propertyRepository.save(property);
    }

    public List<Property> getProperties() {
        return this.propertyRepository.findAll();
    }

    @Transactional
    public void update(Long id, Property update) {
        Property property = (Property)this.propertyRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Property with id" + id + " does not exist");
        });
        if (update.getName() != null && update.getName().length() > 0 && !Objects.equals(property.getName(), update.getName())) {
            property.setName(update.getName());
        }

        if (update.getAddress() != null && update.getAddress().toString().length() > 0 && !Objects.equals(property.getAddress(), update.getAddress())) {
            property.setAddress(update.getAddress());
        }

        if (update.getTenant() != null && update.getTenant().length() > 0 && !Objects.equals(property.getTenant(), update.getTenant())) {
            property.setTenant(update.getTenant());
        }

        if (update.getDescription() != null && update.getDescription().length() > 0 && !Objects.equals(property.getDescription(), update.getDescription())) {
            property.setDescription(update.getDescription());
        }

        if (update.getPropertyType() != null && update.getPropertyType().length() > 0 && !Objects.equals(property.getPropertyType(), update.getPropertyType())) {
            property.setPropertyType(update.getPropertyType());
        }

        if (update.getContact() != null && !Objects.equals(property.getContact(), update.getContact())) {
            property.setContact(update.getContact());
        }

        if (update.getStatus() != null && update.getStatus().length() > 0 && !Objects.equals(property.getStatus(), update.getStatus())) {
            property.setStatus(update.getStatus());
        }

        if (update.getOwner() != null && update.getOwner().toString().length() > 0 && !Objects.equals(property.getOwner(), update.getOwner())) {
            property.setOwner(update.getOwner());
        }

        if (update.getAssetValue() > 0.0 && !Objects.equals(property.getAssetValue(), update.getAssetValue())) {
            property.setAssetValue(update.getAssetValue());
        }

        if (update.getOwner() != null && update.getOwner().toString().length() > 0 && !Objects.equals(property.getOwner(), update.getOwner())) {
            property.setOwner(update.getOwner());
        }

    }

    public Property getProperty(Long id) {
        return (Property)this.propertyRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Property with id" + id + " does not exist");
        });
    }

    public List<Object> getPropertyIdAndName() {
        return this.propertyRepository.selectNameAndID();
    }
}
