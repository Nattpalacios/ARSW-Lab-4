/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.services;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintsPersistence;
import edu.eci.arsw.blueprints.persistence.impl.InMemoryBlueprintPersistence;
import edu.eci.arsw.blueprints.persistence.impl.Tuple;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hcadavid
 */
@Service
public class BlueprintsServices {
   
    @Autowired
    BlueprintsPersistence bpp=null;
    
    @Autowired
    InMemoryBlueprintPersistence memo = null;
    
    public void addNewBlueprint(Blueprint bp){
        
    }
    
    public Set<Blueprint> getAllBlueprints(){
        return null;
    }
    
    /**
     * 
     * @param author blueprint's author
     * @param name blueprint's name
     * @return the blueprint of the given name created by the given author
     * @throws BlueprintNotFoundException if there is no such blueprint
     */
    public Blueprint getBlueprint(String author,String name) throws BlueprintNotFoundException{
    	Blueprint bp = null;
    	final Map<Tuple<String,String>,Blueprint> blueprints = memo.getHash();
    	for (Blueprint b: blueprints.values()) {
    		if(b.getAuthor().equals(author) && b.getName().equals(name)) {
				bp = b;
			}
    	}
		return bp;
    }
    
    /**
     * 
     * @param author blueprint's author
     * @return all the blueprints of the given author
     * @throws BlueprintNotFoundException if the given author doesn't exist
     */
    public Set<Blueprint> getBlueprintsByAuthor(String author) throws BlueprintNotFoundException{
    	Set blueprintsReturn = new HashSet<Blueprint>();
    	final Map<Tuple<String,String>,Blueprint> blueprints = memo.getHash();
    	for(Blueprint b : blueprints.values()) {
    		if(b.getAuthor().equals(author)) {
    			blueprintsReturn.add(b);
    		}
    	}
    	return blueprintsReturn;
    }
    
}
