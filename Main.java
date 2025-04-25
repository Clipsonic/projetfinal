public class Main {

    // ---------- CLASSE Asset ----------
    public static class Asset {
        private String assetId;
        private String nom;
        private String type;
        private String secteur;
        private String devise;
        private String pays;

        public Asset(String assetId, String nom, String type, String secteur, String devise, String pays) {
            setAssetId(assetId);
            setNom(nom);
            setType(type);
            setSecteur(secteur);
            setDevise(devise);
            setPays(pays);
        }

        public String getAssetId() { return assetId; }
        public String getNom() { return nom; }
        public String getType() { return type; }
        public String getSecteur() { return secteur; }
        public String getDevise() { return devise; }
        public String getPays() { return pays; }

        public void setAssetId(String assetId) { this.assetId = assetId; }
        public void setNom(String nom) { this.nom = nom; }
        public void setType(String type) { this.type = type; }
        public void setSecteur(String secteur) { this.secteur = secteur; }
        public void setDevise(String devise) { this.devise = devise; }
        public void setPays(String pays) { this.pays = pays; }
    }

    // ---------- CLASSE Cours ----------
    public static class Cours {
        private String valueId;
        private String assetId;
        private String date;
        private double prixOuverture;
        private double prixFermeture;

        public Cours(String valueId, String assetId, String date, double prixOuverture, double prixFermeture) {
            setValueId(valueId);
            setAssetId(assetId);
            setDate(date);
            setPrixOuverture(prixOuverture);
            setPrixFermeture(prixFermeture);
        }

        public String getValueId() { return valueId; }
        public String getAssetId() { return assetId; }
        public String getDate() { return date; }
        public double getPrixOuverture() { return prixOuverture; }
        public double getPrixFermeture() { return prixFermeture; }

        public void setValueId(String valueId) { this.valueId = valueId; }
        public void setAssetId(String assetId) { this.assetId = assetId; }
        public void setDate(String date) { this.date = date; }
        public void setPrixOuverture(double prixOuverture) { this.prixOuverture = prixOuverture; }
        public void setPrixFermeture(double prixFermeture) { this.prixFermeture = prixFermeture; }

        public double getRendementJournalier() {
            return (prixFermeture - prixOuverture) / prixOuverture;
        }
    }

    // ---------- CLASSE Portefeuille ----------
    public static class Portefeuille {
        private String portefeuilleId;
        private String assetId;
        private int quantite;
        private String dateAchat;
        private double prixAchat;

        public Portefeuille(String portefeuilleId, String assetId, int quantite, String dateAchat, double prixAchat) {
            setPortefeuilleId(portefeuilleId);
            setAssetId(assetId);
            setQuantite(quantite);
            setDateAchat(dateAchat);
            setPrixAchat(prixAchat);
        }

        public String getPortefeuilleId() { return portefeuilleId; }
        public String getAssetId() { return assetId; }
        public int getQuantite() { return quantite; }
        public String getDateAchat() { return dateAchat; }
        public double getPrixAchat() { return prixAchat; }

        public void setPortefeuilleId(String portefeuilleId) { this.portefeuilleId = portefeuilleId; }
        public void setAssetId(String assetId) { this.assetId = assetId; }
        public void setQuantite(int quantite) {
            if (quantite < 0) throw new IllegalArgumentException("Quantité négative interdite.");
            this.quantite = quantite;
        }
        public void setDateAchat(String dateAchat) { this.dateAchat = dateAchat; }
        public void setPrixAchat(double prixAchat) {
            if (prixAchat < 0) throw new IllegalArgumentException("Prix d'achat négatif interdit.");
            this.prixAchat = prixAchat;
        }

        public double getCoutTotal() {
            return quantite * prixAchat;
        }
    }

    // ---------- MÉTHODE MAIN ----------
    public static void main(String[] args) {
        Asset asset1 = new Asset("A1", "Apple Inc", "Action", "Technologie", "USD", "USA");
        Cours cours1 = new Cours("V1", "A1", "2023-01-01", 130.0, 135.0);
        Portefeuille port1 = new Portefeuille("P1", "A1", 10, "2022-12-15", 120.0);

        System.out.println("Nom de l'actif : " + asset1.getNom());
        System.out.println("Rendement journalier : " + cours1.getRendementJournalier());
        System.out.println("Coût total d'achat : " + port1.getCoutTotal());
    }
}

