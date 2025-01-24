package ec.edu.espe.accountingsystem.view;


import ec.edu.espe.accountingsystem.controller.CustomerController;
import ec.edu.espe.accountingsystem.controller.UserController;
import ec.edu.espe.accountingsystem.exception.InvalidIdentityCardException;

import ec.edu.espe.accountingsystem.exception.InvalidIdentityCardException;
import ec.edu.espe.accountingsystem.model.Customer;
import ec.edu.espe.accountingsystem.model.CustomersRecord;
import ec.edu.espe.accountingsystem.model.IdentityCard;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrés Espinosa
 */
public class FrmCustomerAddition extends javax.swing.JFrame {
    
        String id;
        String name;
        String type;
        IdentityCard identityCard;
        String identityCardType;
        String identityCardId;
        String address;
        String phoneNumber;
        String email;

    CustomerController customerController;
    UserController userController;

    /**
     * Creates new form CostumerAddition
     */
    public FrmCustomerAddition() {
        initComponents();

        customerController = new CustomerController();
        userController = new UserController();
        lblIdVoidField.setVisible(false);
        lblTypeVoidField.setVisible(false);
        lblNameVoidField.setVisible(false);
        lblIdentityCardTypeVoidField.setVisible(false);
        lblIdentityCardIdVoidField.setVisible(false);
        lblAddressVoidField.setVisible(false);
        lblPhoneNumberVoidField.setVisible(false);
        lblEmailVoidField.setVisible(false);
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdd = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        labelAddACostumer = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        labelId = new javax.swing.JLabel();
<<<<<<< HEAD
=======
        txtId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtIdentityCardType = new javax.swing.JTextField();
        txtIdentityCardId = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
>>>>>>> 322cd0604aec6bda80e3c93b9c15319539c9717b
        labelName = new javax.swing.JLabel();
        labelIdcardType = new javax.swing.JLabel();
        labelIdCardId = new javax.swing.JLabel();
        labelAdress = new javax.swing.JLabel();
        labelPhoneNumber = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
<<<<<<< HEAD
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtDocumentIdentityNumber = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        cmbxDocumentIdentityCardType = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cmbxType = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

=======
        btnAdd = new javax.swing.JButton();
        btnBackToMenu = new javax.swing.JButton();
        lblIdVoidField = new javax.swing.JLabel();
        lblNameVoidField = new javax.swing.JLabel();
        lblIdentityCardTypeVoidField = new javax.swing.JLabel();
        lblIdentityCardIdVoidField = new javax.swing.JLabel();
        lblAddressVoidField = new javax.swing.JLabel();
        lblPhoneNumberVoidField = new javax.swing.JLabel();
        lblEmailVoidField = new javax.swing.JLabel();
        labelType = new javax.swing.JLabel();
        txtType = new javax.swing.JTextField();
        lblTypeVoidField = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelAddACostumer.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelAddACostumer.setText("Añadir un Cliente");

        labelId.setText("ID:");

        labelName.setText("Name:");

        labelIdcardType.setText("Identity card type: ");

        labelIdCardId.setText("Identity Card ID:");

        labelAdress.setText("Adress:");

        labelPhoneNumber.setText("Phone Number:");

        labelEmail.setText("Email:");

>>>>>>> 322cd0604aec6bda80e3c93b9c15319539c9717b
        btnAdd.setBackground(new java.awt.Color(34, 51, 186));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Añadir");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

<<<<<<< HEAD
        labelAddACostumer.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelAddACostumer.setText("Añade un cliente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(labelAddACostumer)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(labelAddACostumer)
                .addGap(23, 23, 23))
        );

        labelId.setText("ID:");

        labelName.setText("Nombre:");

        labelIdcardType.setText("Tipo de documento de identidad: ");

        labelIdCardId.setText("Número del documento de identidad:");

        labelAdress.setText("Dirección:");

        labelPhoneNumber.setText("Numero de teléfono:");

        labelEmail.setText("Correo electrónico: ");

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        cmbxDocumentIdentityCardType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "cedula", "ruc" }));

        jLabel1.setText("Tipo:");

        cmbxType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "minorista", "mayorista", "distribuidor" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelIdCardId)
                            .addComponent(labelAdress)
                            .addComponent(labelEmail)
                            .addComponent(labelPhoneNumber))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDocumentIdentityNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelIdcardType, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelName)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbxDocumentIdentityCardType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelId, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelIdcardType, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbxDocumentIdentityCardType, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIdCardId)
                    .addComponent(txtDocumentIdentityNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelAdress, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPhoneNumber, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        jMenu1.setText("Regresar menu principal");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);
=======
        btnBackToMenu.setBackground(new java.awt.Color(34, 51, 186));
        btnBackToMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnBackToMenu.setText("Regresar al Menú");
        btnBackToMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackToMenuActionPerformed(evt);
            }
        });

        lblIdVoidField.setForeground(new java.awt.Color(255, 51, 51));
        lblIdVoidField.setText("*Campo Vacío");

        lblNameVoidField.setForeground(new java.awt.Color(255, 51, 51));
        lblNameVoidField.setText("*Campo Vacío");

        lblIdentityCardTypeVoidField.setForeground(new java.awt.Color(255, 51, 51));
        lblIdentityCardTypeVoidField.setText("*Campo Vacío");

        lblIdentityCardIdVoidField.setForeground(new java.awt.Color(255, 51, 51));
        lblIdentityCardIdVoidField.setText("*Campo Vacío");

        lblAddressVoidField.setForeground(new java.awt.Color(255, 51, 51));
        lblAddressVoidField.setText("*Campo Vacío");

        lblPhoneNumberVoidField.setForeground(new java.awt.Color(255, 51, 51));
        lblPhoneNumberVoidField.setText("*Campo Vacío");

        lblEmailVoidField.setForeground(new java.awt.Color(255, 51, 51));
        lblEmailVoidField.setText("*Campo Vacío");

        labelType.setText("Type:");

        lblTypeVoidField.setForeground(new java.awt.Color(255, 51, 51));
        lblTypeVoidField.setText("*Campo Vacío");
>>>>>>> 322cd0604aec6bda80e3c93b9c15319539c9717b

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
<<<<<<< HEAD
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addGap(36, 36, 36))
=======
                .addGap(33, 33, 33)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                .addComponent(btnBackToMenu)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(labelId)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(labelAddACostumer)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(txtId))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelName)
                            .addComponent(labelIdcardType, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelType)))
                    .addComponent(labelIdCardId)
                    .addComponent(labelPhoneNumber)
                    .addComponent(labelAdress)
                    .addComponent(labelEmail))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAddress)
                    .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtIdentityCardType, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtIdentityCardId, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtEmail)
                    .addComponent(txtType)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIdVoidField)
                            .addComponent(lblEmailVoidField)
                            .addComponent(lblPhoneNumberVoidField)
                            .addComponent(lblAddressVoidField)
                            .addComponent(lblIdentityCardIdVoidField)
                            .addComponent(lblIdentityCardTypeVoidField)
                            .addComponent(lblNameVoidField)
                            .addComponent(lblTypeVoidField))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
>>>>>>> 322cd0604aec6bda80e3c93b9c15319539c9717b
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
<<<<<<< HEAD
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAdd)
                .addContainerGap(36, Short.MAX_VALUE))
=======
                .addGap(16, 16, 16)
                .addComponent(labelAddACostumer)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(labelType))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblIdVoidField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTypeVoidField)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNameVoidField)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdentityCardType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelIdcardType))
                .addGap(3, 3, 3)
                .addComponent(lblIdentityCardTypeVoidField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIdCardId)
                    .addComponent(txtIdentityCardId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIdentityCardIdVoidField)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAdress))
                .addGap(2, 2, 2)
                .addComponent(lblAddressVoidField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPhoneNumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPhoneNumberVoidField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmailVoidField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBackToMenu)
                    .addComponent(btnAdd))
                .addGap(16, 16, 16))
>>>>>>> 322cd0604aec6bda80e3c93b9c15319539c9717b
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        String id;
        String typeInSpanish;
        String type = null;
        String name;
        String identityCardType;
        String identityCardNumber;
        String address;
        String phoneNumber;
        String email;
        boolean isValid;

        id = txtID.getText();
        typeInSpanish = cmbxType.getSelectedItem().toString();

        switch (typeInSpanish) {
            case "minorista":
                type = "retail";
                break;
            case "mayorista":
                type = "wholesale";
                break;
            case "distribuidor":
                type = "distributor";
                break;
        }

        name = txtName.getText();
        identityCardType = cmbxDocumentIdentityCardType.getSelectedItem().toString();
        identityCardNumber = txtDocumentIdentityNumber.getText();
        address = txtAddress.getText();
        phoneNumber = txtPhoneNumber.getText();
        email = txtEmail.getText();
        try {

            isValid = customerController.addCustomer(id, type, name, identityCardType, identityCardNumber, address, phoneNumber, email);

            if (isValid) {
                JOptionPane.showMessageDialog(rootPane, "Añadido exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane, "No se pudo añadir", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (InvalidIdentityCardException ex) {
            JOptionPane.showMessageDialog(rootPane, "No se pudo añadir", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnAddActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        if(userController.isAdministrator()){
            FrmAdministrator frmAdministrator = new FrmAdministrator();
            frmAdministrator.setVisible(true);
        }else{
            FrmSeller frmSeller = new FrmSeller();
            frmSeller.setVisible(true);           
        }
        
        this.setVisible(false);
    }//GEN-LAST:event_jMenu1MouseClicked

        boolean validatedData;
        if(txtId.getText().trim().isEmpty()){
            
            lblIdVoidField.setVisible(true);
            validatedData = false;
        }else{
            lblIdVoidField.setVisible(false);
            id = txtId.getText();
            validatedData = true;
        }
        
        if(txtName.getText().trim().isEmpty()){
            
            lblNameVoidField.setVisible(true);
            validatedData = false;
        }else{
            lblNameVoidField.setVisible(false);
            name = txtName.getText();
            validatedData = true;
        }
        
        if(txtType.getText().trim().isEmpty()){
            
            lblTypeVoidField.setVisible(true);
            validatedData = false;
        }else{
            lblTypeVoidField.setVisible(false);
            type = txtType.getText();
            validatedData = true;
        }
        
        if(txtIdentityCardType.getText().trim().isEmpty()){
            
            lblIdentityCardTypeVoidField.setVisible(true);
            validatedData = false;
        }else{
            lblIdentityCardTypeVoidField.setVisible(false);
            identityCardType = txtIdentityCardType.getText();
            validatedData = true;
        }
        
        if(txtIdentityCardId.getText().trim().isEmpty()){
            
            lblIdentityCardIdVoidField.setVisible(true);
            validatedData = false;
        }else{
            lblIdentityCardIdVoidField.setVisible(false);
            identityCardId = txtIdentityCardId.getText();
            validatedData = true;
        }
        
        
            try {
                identityCard = new IdentityCard(identityCardType, identityCardId);
                validatedData = true;
            } catch (InvalidIdentityCardException ex) {
                Logger.getLogger(FrmSupplierAddition.class.getName()).log(Level.SEVERE, null, ex);
                validatedData = false;
            }
            
        if(txtAddress.getText().trim().isEmpty()){
            
            lblAddressVoidField.setVisible(true);
            validatedData = false;
        }else{
            lblAddressVoidField.setVisible(false);
            address = txtAddress.getText();
            validatedData = true;
        }
        
        if(txtPhoneNumber.getText().trim().isEmpty()){
            
            lblPhoneNumberVoidField.setVisible(true);
            validatedData = false;
        }else{
            lblPhoneNumberVoidField.setVisible(false);
            phoneNumber = txtPhoneNumber.getText();
            validatedData = true;
        }
        
        if(txtEmail.getText().trim().isEmpty()){
            
            lblEmailVoidField.setVisible(true);
            validatedData = false;
        }else{
            lblEmailVoidField.setVisible(false);
            email = txtEmail.getText();
            validatedData = true;
        }
        
        if(validatedData==true){
            Customer customer = new Customer(id, type, name, identityCard, address, phoneNumber, email);

            CustomersRecord customers = new CustomersRecord();

            customers.add(customer);
            
            JOptionPane.showMessageDialog(rootPane, "Se han guardado los datos correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
            txtId.setText("");
            txtType.setText("");
            txtName.setText("");
            txtIdentityCardType.setText("");
            txtIdentityCardId.setText("");
            txtAddress.setText("");
            txtPhoneNumber.setText("");
            txtEmail.setText("");
            
        }else{
            JOptionPane.showMessageDialog(rootPane, "Campos no llenados correctamente", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }                                      

    private void btnBackToMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackToMenuActionPerformed
        FrmAdministrator administratorWindow = new FrmAdministrator();
        administratorWindow.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btnBackToMenuActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCustomerAddition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCustomerAddition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCustomerAddition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCustomerAddition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCustomerAddition().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JComboBox<String> cmbxDocumentIdentityCardType;
    private javax.swing.JComboBox<String> cmbxType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelAddACostumer;
    private javax.swing.JLabel labelAdress;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelIdCardId;
    private javax.swing.JLabel labelIdcardType;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelPhoneNumber;
<<<<<<< HEAD
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtDocumentIdentityNumber;
=======
    private javax.swing.JLabel labelType;
    private javax.swing.JLabel lblAddressVoidField;
    private javax.swing.JLabel lblEmailVoidField;
    private javax.swing.JLabel lblIdVoidField;
    private javax.swing.JLabel lblIdentityCardIdVoidField;
    private javax.swing.JLabel lblIdentityCardTypeVoidField;
    private javax.swing.JLabel lblNameVoidField;
    private javax.swing.JLabel lblPhoneNumberVoidField;
    private javax.swing.JLabel lblTypeVoidField;
    private javax.swing.JTextField txtAddress;
>>>>>>> 322cd0604aec6bda80e3c93b9c15319539c9717b
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables
}
