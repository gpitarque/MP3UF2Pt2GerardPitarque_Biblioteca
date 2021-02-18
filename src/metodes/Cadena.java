/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodes;

import java.util.Scanner;

import java.util.Scanner;

/**
 *
 * @author alumne
 */
public class Cadena {
    
    public static int buscaCadena(String primer, String segon, int pos){
        //Casos especials
        if(primer==null || segon==null || pos>=primer.length()) return -1;
        if(pos<0) pos=0;
        if(segon.length()==0) return pos<primer.length()?pos:primer.length();
        
        //Tractament de cas normal
        return primer.indexOf(segon, pos);
    }
    
    //El mètode retornarà un String resultat d'insertar el segon String en el primer 
    //a la posició especificada pel número (recordeu que comencen per 0)
    public static String insertaCadena(String primer, String segon, int posicio){
        //Tractament de casos especials
        //si els 2 Strings són null el mètode retornarà null,
        //si només un d'ells és null retornarà l'String no null,
        //si el número és negatiu se farà el mateix que si valguès 0,
        //si el número és superior a la llargada del primer String, se farà el 
        //mateix que si valgués la llargada.   
        if(primer==null && segon==null) return null;
        if(primer==null && segon!=null) return segon;
        if(primer!=null && segon==null) return primer;
        if(posicio<0) posicio=0;
        if(posicio>primer.length()) posicio=primer.length();
        
        //Declaracio de variables
        String resultat="";
        
        //Extreure el troç inicial de primer des de el primer caràcter fins 
        //l'anterior a posicio
        for (int i = 0; i < posicio; i++) {
            resultat+=primer.charAt(i);
        }
        //Versió curta
        //resultat=primer.substring(0, posicio);
        
        //Ara concatenem tot el segon String al resultat
        resultat+=segon;
        
        //Ara només falta concatenar el troç final del primer String al resultat
        for (int i = posicio; i < primer.length(); i++) {
            resultat+=primer.charAt(i);
        }
        //Versió curta
        //resultat=primer.substring(posicio);

        //Finalment retornem la cadena que conté el resultat desitjat
        return resultat;
    }
    
    
    public static String retornaCadenaBuida(){
        return "";
        
    }
    
    
    public static String llegirLinies(String missatge, char carFin){
        Scanner ent = new Scanner(System.in);
        String text="";
        
        //Demanem a l'usuari la introducció del text
        System.out.println(missatge);
        do {         
            String linia=ent.nextLine().trim();
            
            //Concatenem la línia al text
            text=text+linia;
            
            //Mirem si és o no la última línia del text
            if(linia.endsWith(carFin+"")) break;
            else text+='\n';    //Si no és la última afegixo un salt de línia
        } while (true);
        
        return text;
        
    }
    
    //Mètode que retorna un vector d'enters que conté les posicions on apareix
    //la subcadena dins del text. Si no apareix retornem un vector de 0 caselles
    public static int[] buscaCadenaMultiple(String cadena, String subcadena){
        int cont=0, index=0, 
                i;    //l'índex del vector
        int[] resultat=null;
        
        //Compto quantes aparicions hi ha per poder declarar la dimensió del vector
        do{
            index=buscaCadena(cadena,subcadena,index);
            if(index==-1) break;
            cont++;
            //Incrementem l'index per evitar el bucle infinit
            index++;
        }while(true);
        //Instancio el vector en el número de caselles indicat per la variable cont
        resultat=new int[cont];
        
        //Torno a inicialitzar les variables
        index=0;
        i=0;    //inicialitzo a 0 per què omplirem el vector d'esquerra a dreta 
        do{
            index=buscaCadena(cadena,subcadena,index);
            if(index==-1) break;
            resultat[i++]=index;
            //Incrementem l'index per evitar el bucle infinit
            index++;
        }while(true);
        
        return resultat;
        
    }
    
    
    //Pràctica 2. UF2. Mètode que retorna concatenades les cadenes començant per
                     //la primera i saltant a les indicades pel número rebut com
                     //a paràmetre.
    public static String juntaSaltejats (int numeroSalts, String... cadena){
        //Tractament casos especials
        if (cadena==null){
            return null;
        }
        if (numeroSalts<1){
            return "0";
        }
        else{
            return null;
        }
    
    }
}
        
        
    

    
        

 
    
    
    
 


/*
public static int[] buscaCadenaMultiple(String text, String subcadena){
        int[] resultat;
        int cont=0, index=0, i=0;
        
        do{
            index=buscaCadena(text,subcadena,index);
            if(index==-1) break;
            cont++;
            //System.out.println(index);
            //Incrementem l'index per evitar el bucle infinit
            index++;
        }while(true);
        
        resultat=new int[cont];
        index=0;
        do{
            index=buscaCadena(text,subcadena,index);
            if(index==-1) break;
            resultat[i++]=index;
            //Incrementem l'index per evitar el bucle infinit
            index++;
        }while(true);
        
        return resultat;
    
    
    }



*/
