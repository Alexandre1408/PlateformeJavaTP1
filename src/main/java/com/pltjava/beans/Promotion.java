package com.pltjava.beans;

import java.util.ArrayList;
import java.util.Collections;

public class Promotion {
    private ArrayList<Etudiant> listeEtu = new ArrayList<Etudiant>();
    private ArrayList<Matiere> listeMat = new ArrayList<Matiere>();
    private float moyennePromotion;
    private String nomPromotion;
    

    public Promotion(String nomPromo,ArrayList<Etudiant> listeEtu, ArrayList<Matiere> listeMat) 
    {
        nomPromotion = nomPromo;
        setListeEtu(listeEtu);
        setListeMat(listeMat);
        moyennePromotion = moyennePromotion();
    }
    
    public float moyennePromotion()
    {
        float sommeMoyennePromo = 0;
        
        if(listeEtu.size() == 0)
        { 
            return 0; 
        }
        else
        {
            for(Etudiant etudiantIterator : listeEtu)
            {
                sommeMoyennePromo += etudiantIterator.getMoyenneGeneral();
            }
            return sommeMoyennePromo/listeEtu.size();
        }

    }
    
    
    public String getNomPromotion() {
        return nomPromotion;
    }

    public void setNomPromotion(String nomPromotion) {
        this.nomPromotion = nomPromotion;
    }

    public ArrayList<Etudiant> getSortedEtudiantByMoyenne() 
    {         
        Collections.sort(listeEtu);         
        return listeEtu;     
    } 
    
    public float getMoyennePromotion() {
        return moyennePromotion;
    }

    public void setMoyennePromotion(float moyennePromotion) {
        this.moyennePromotion = moyennePromotion;
    }
    
    public ArrayList<Etudiant> getListeEtu() {
        return listeEtu;
    }
    public void setListeEtu(ArrayList<Etudiant> listeEtu) {
        this.listeEtu = listeEtu;
    }
    public ArrayList<Matiere> getListeMat() {
        return listeMat;
    }
    public void setListeMat(ArrayList<Matiere> listeMat) {
        this.listeMat = listeMat;
    }
    
    //Ajoute un etudiant dans la liste des etudiants
    public void addEtudiant(Etudiant etuToAdd)
    {
    	listeEtu.add(etuToAdd);
    }
    
    //Enleve un etudiant dans la liste des etudiants
    public void removeEtudiant(Etudiant etuToRemove)
    {
    	listeEtu.remove(etuToRemove);
    }
    
    //Ajoute une matiere dans la liste des matieres
    public void addMatiere(Matiere matiereToAdd)
    {
    	listeMat.add(matiereToAdd);
    }
    
    //Enleve une matiere dans la liste des matieres
    public void removeMatiere(Matiere matiereToRemove)
    {
    	listeMat.remove(matiereToRemove);
    }
    
}