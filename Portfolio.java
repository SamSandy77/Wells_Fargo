package com.example.demo.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    private String createdDate;

    // One portfolio belongs to one client
    @OneToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    // One portfolio can have many securities
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Security> securities;

    public Portfolio() {}

    public Portfolio(String createdDate, Client client) {
        this.createdDate = createdDate;
        this.client = client;
    }

    // Getters and setters
    public Long getPortfolioId() { return portfolioId; }
    public String getCreatedDate() { return createdDate; }
    public void setCreatedDate(String createdDate) { this.createdDate = createdDate; }
    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
    public List<Security> getSecurities() { return securities; }
    public void setSecurities(List<Security> securities) { this.securities = securities; }
}
