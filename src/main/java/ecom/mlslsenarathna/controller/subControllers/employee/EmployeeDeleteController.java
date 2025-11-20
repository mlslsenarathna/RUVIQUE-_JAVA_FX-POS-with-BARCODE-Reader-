package ecom.mlslsenarathna.controller.subControllers.employee;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import ecom.mlslsenarathna.model.dto.AddressDTO;
import ecom.mlslsenarathna.model.dto.EmployeeDTO;
import ecom.mlslsenarathna.service.AddressService;
import ecom.mlslsenarathna.service.EmployeeService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class EmployeeDeleteController {
    EmployeeService employeeService=new EmployeeService();
    AddressService addressService=new AddressService();

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtNic;

    @FXML
    private JFXTextField txtSerchInput;

    @FXML
    void btnBackOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        EmployeeDTO employeeDTO=employeeService.searchByEmployerNic(txtSerchInput.getText());
        AddressDTO addressDTO=addressService.getAddressById(employeeDTO.getAddressId());
        employeeService.deleteEmployee(employeeDTO);
        addressService.deleteByAddressId(employeeDTO.getAddressId());

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        EmployeeDTO employeeDTO=employeeService.searchByEmployerNic(txtSerchInput.getText());
        AddressDTO addressDTO=addressService.getAddressById(employeeDTO.getAddressId());
        setDetails(employeeDTO,addressDTO);
    }

    private void setDetails(EmployeeDTO employeeDTO, AddressDTO addressDTO) {
        txtName.setText(employeeDTO.getEmplyeeName());
        txtAddress.setText(addressDTO.getAddressLine1()+","+addressDTO.getAdddressLine2()+","+addressDTO.getCity());
        txtContact.setText(employeeDTO.getContactNo());
        txtNic.setText(employeeDTO.getNationalId());
    }

    @FXML
    void txtSerchInputOnAction(ActionEvent event) {
        EmployeeDTO employeeDTO=employeeService.searchByEmployerNic(txtSerchInput.getText());
        AddressDTO addressDTO=addressService.getAddressById(employeeDTO.getAddressId());
        setDetails(employeeDTO,addressDTO);
    }

}
