/*package com.example.demo.adminModel;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="admin")
public class adminModel {
	
	
	public adminModel() {}
	
	
	public adminModel(String adminName, String adminPassword) {
		super();
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long adminID;
	
	@Column(name="adminName")
	private String adminName;
	
	@Column(name="adminPassword")
	private String adminPassword;
	
	
	
	
	public long getAdminID() {
		return adminID;
	}
	public void setAdminID(long adminID) {
		this.adminID = adminID;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	
	
	
}
*/

package com.example.demo.adminModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="admin")
public class adminModel {
    
    public adminModel() {}
    
    public adminModel(String adminName, String adminPassword, String adminEmail) {
        super();
        this.adminName = adminName;
        this.adminPassword = adminPassword;
        this.adminEmail = adminEmail; // Add email to constructor
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long adminID;
    
    @Column(name="adminName")
    private String adminName;
    
    @Column(name="adminPassword")
    private String adminPassword;

    @Column(name="adminEmail") // Make sure the column name matches your database
    private String adminEmail; // Add this field

    // Getters and Setters
    public long getAdminID() {
        return adminID;
    }
    public void setAdminID(long adminID) {
        this.adminID = adminID;
    }
    public String getAdminName() {
        return adminName;
    }
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    public String getAdminPassword() {
        return adminPassword;
    }
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
    public String getAdminEmail() { // Add getter for adminEmail
        return adminEmail;
    }
    public void setAdminEmail(String adminEmail) { // Add setter for adminEmail
        this.adminEmail = adminEmail;
    }
}

