//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.controler.propertyManagement;

import com.cicosy.tenant_management.model.propertyManagement.Property;
import com.cicosy.tenant_management.service.propertyManagement.PropertyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(
        path = {"/api/property"}
)
public class propertyController {
    private final PropertyService propertyService;
    private final AddressController addressController;
    private final OwnerController ownerController;
    private final ContactDetailsController contactDetailsController;
    private final CompartmentController compartmentController;

    @Autowired
    public propertyController(PropertyService propertyService, AddressController addressController, OwnerController ownerController, ContactDetailsController contactDetailsController, CompartmentController compartmentController) {
        this.propertyService = propertyService;
        this.addressController = addressController;
        this.ownerController = ownerController;
        this.contactDetailsController = contactDetailsController;
        this.compartmentController = compartmentController;
    }

    @PostMapping({"/save-property"})
    public Property saveProperty(@RequestBody Property property) {
        property.getAddressObject().setProperty(property.getId());
        property.setAddress(this.addressController.saveAddress(property.getAddressObject()));
        property.setOwner(this.ownerController.newOwner(property.getOwnerObject()));
        property.setContact(this.contactDetailsController.saveContact(property.getPropertyContactObject()));
        this.propertyService.saveProperty(property);
        return property;
    }

    @GetMapping({"/get-all-properties"})
    public List<Property> getProperties() {
        List<Property> properties = this.propertyService.getProperties();

        for(int i = 0; i < properties.size(); ++i) {
            ((Property)properties.get(i)).setAddressObject(this.addressController.getAddress(((Property)properties.get(i)).getAddress()));
            ((Property)properties.get(i)).setOwnerObject(this.ownerController.getOwner(((Property)properties.get(i)).getOwner()));
            ((Property)properties.get(i)).setPropertyContactObject(this.contactDetailsController.getContact(((Property)properties.get(i)).getContact()));
            ((Property)properties.get(i)).setNumberOfCompartments(this.compartmentController.getCompartmentsForSpecificProperty(((Property)properties.get(i)).getId()).size());
        }

        return properties;
    }

    @GetMapping({"/get-property/{id}"})
    public Property getProperty(@PathVariable Long id) {
        Property property = this.propertyService.getProperty(id);
        property.setAddressObject(this.addressController.getAddress(property.getAddress()));
        property.setOwnerObject(this.ownerController.getOwner(property.getOwner()));
        property.setPropertyContactObject(this.contactDetailsController.getContact(property.getContact()));
        property.setNumberOfCompartments(this.compartmentController.getCompartmentsForSpecificProperty(property.getId()).size());
        return property;
    }

    @PutMapping({"/update-property/{id}"})
    public Property updateProperty(@PathVariable Long id, @RequestBody Property property) {
        this.propertyService.update(id, property);
        return this.propertyService.getProperty(id);
    }

    @GetMapping({"/get-property-id-and-name"})
    public List<Object> propertyIdAndName() {
        return this.propertyService.getPropertyIdAndName();
    }
}
