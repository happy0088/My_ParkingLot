/**
 * 
 */
package com.gojek.parking_lot.command;

import com.gojek.parking_lot.exception.InvalidInputException;

/**
 * @author happy Singh
 *
 */
public interface ICommand {

	public String execute(String[] args) throws InvalidInputException;
}
