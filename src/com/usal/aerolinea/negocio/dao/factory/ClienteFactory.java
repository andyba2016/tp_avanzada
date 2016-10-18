package com.usal.aerolinea.negocio.dao.factory;

import com.usal.aerolinea.negocio.dao.implementaciones.ClienteImplFile;
import com.usal.aerolinea.negocio.dao.implementaciones.ClienteImplJDBC;
import com.usal.aerolinea.negocio.dao.interfaces.ClienteInterface;

public class ClienteFactory {
	
	public static ClienteInterface getImplementacion(String str) {
		if(str.equalsIgnoreCase("file")) {
			return new ClienteImplFile();
		} else if(str.equalsIgnoreCase("jdbc")) {
			return new ClienteImplJDBC();
		}
		return null;
	}

}
