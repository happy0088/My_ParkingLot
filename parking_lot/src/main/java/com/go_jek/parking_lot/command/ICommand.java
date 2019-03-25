/**
 * 
 */
package com.go_jek.parking_lot.command;

import com.go_jek.parking_lot.exception.InvalidInputException;

/**
 * @author happy Singh
 *
 */
public interface ICommand {

	public void execute(String[] args) throws InvalidInputException;
}
