/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * Copyright (C) 2003-2015 E.R.P. Consultores y Asociados, C.A.               *
 * All Rights Reserved.                                                       *
 * Contributor(s): Yamel Senih www.erpya.com                                  *
 *****************************************************************************/
package org.spin.util.support.webdav;

import java.sql.Timestamp;
import java.util.Date;

import org.adempiere.exceptions.AdempiereException;

import com.github.sardine.DavResource;

/**
 * Resource wrapper for Sardine resource
 * @author Yamel Senih, ySenih@erpya.com, ERPCyA http://www.erpya.com
 *		<a href="https://github.com/adempiere/adempiere/issues/2109">
 * 		@see FR [ 2109 ] Add App Registration ADempiere</a>
 */
public class SardineResource implements IWebDavResource {
	
	public SardineResource(DavResource resource) {
		if(resource == null) {
			throw new AdempiereException("@Resource@ @NotFound@");
		}
		this.resource = resource;
	}
	
	/**	Resource	*/
	private DavResource resource;

	@Override
	public String getDisplayName() {
		return resource.getDisplayName();
	}

	@Override
	public String getName() {
		return resource.getName();
	}

	@Override
	public String getPath() {
		return resource.getPath();
	}

	@Override
	public Timestamp getCreated() {
		Date created = resource.getCreation();
		if(created == null) {
			return null;
		}
		return new Timestamp(created.getTime());
	}

	@Override
	public Timestamp getUpdated() {
		Date updated = resource.getModified();
		if(updated == null) {
			return null;
		}
		return new Timestamp(updated.getTime());
	}
	
	@Override
	public String toString() {
		return resource.toString();
	}
}
