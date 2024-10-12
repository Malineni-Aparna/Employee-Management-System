package com.example.demo.adminController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder; // Import for PasswordEncoder
import com.example.demo.adminRepository.adminRepository; // Use your provided naming convention
import com.example.demo.adminLoginDto.AdminLoginDto;
import com.example.demo.adminModel.adminModel;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin // Enable CORS if needed
public class adminController { // Kept your naming convention

    @Autowired
    private adminRepository repo; // Kept your naming convention

    @Autowired
    private PasswordEncoder passwordEncoder; // Inject PasswordEncoder interface

    // Login method
    @PostMapping("/admin/login")
    public ResponseEntity<String> login(@Validated @RequestBody AdminLoginDto loginDto) {
        // Fetch the admin based on email
        adminModel admin = repo.findByAdminEmail(loginDto.getAdminEmail());

        // Check if the admin exists and the password matches
        if (admin != null && passwordEncoder.matches(loginDto.getAdminPassword(), admin.getAdminPassword())) {
            return ResponseEntity.ok("Login successful"); // Customize the response as needed
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }

    // Get all admins
    @GetMapping("/admin")
    public List<adminModel> getAllAdmins() {
        return repo.findAll();
    }
}
