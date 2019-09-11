package edu.eci.arsw.blueprints;

import org.springframework.beans.factory.annotation.Autowired;

import edu.eci.arsw.blueprints.services.BlueprintsServices;

public class Main {

	BlueprintsServices s = new BlueprintsServices();
	
	
	public static void main(String[] args) {
		System.out.println("Hola mundo");
		//System.out.println(s.);

	}

}
