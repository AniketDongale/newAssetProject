package com.company.controller;

import java.util.List;

import com.company.entity.Assets;
import com.company.entity.Employee;
import com.company.entity.Order;
import com.company.entity.Ticket;
import com.company.exceptions.DuplicateAsset;
import com.company.exceptions.InvalidAssetId;
import com.company.exceptions.InvalidEmployeeId;
import com.company.exceptions.InvalidOrderId;
import com.company.exceptions.NoAssetsFound;
import com.company.exceptions.NoAuthority;
import com.company.exceptions.NoOrderFound;
import com.company.service.EmployeeService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	//place order
	@PostMapping(path="/{id}/order/raise")
	public String addOrder(@PathVariable("id") long id,@RequestBody ObjectNode object ) throws InvalidAssetId, InvalidEmployeeId, NoAuthority, DuplicateAsset  {
		long empId = object.get("empId").asLong();
		long assetId = object.get("assetId").asLong();
		return empService.raiseRequest(id,empId ,assetId);
		
	}
	
	//return order
	@PutMapping(path = "/{id}/order/return",consumes = "application/json")
	public String returnOrder(@PathVariable("id") long id,@RequestBody ObjectNode object) throws InvalidAssetId, NoAuthority, InvalidEmployeeId, InvalidOrderId {
		long orderId = object.get("orderId").asLong();
		empService.returnRequest(id,orderId);
		return "Order id "+orderId+" will return";
	}
	
	//allocate the order
	@PutMapping(path="/{id}/order/allocate",consumes = "application/json")
	public String allocateOrder(@PathVariable long id ,@RequestBody ObjectNode object) throws NoAuthority, InvalidOrderId, InvalidEmployeeId{
		long orderId = object.get("orderId").asLong();
		return empService.allocateOrder(id,orderId);
		
	}
	
	
	//get pending order ticket
	@GetMapping(path = "/{id}/orders/pending")
	public List<Ticket> showPendingRequest(@PathVariable("id")long id) throws InvalidEmployeeId, NoAuthority, NoOrderFound {
		return empService.showAllPendingOrder(id);
	}
	//reject the order
	@PutMapping(path="/{id}/order/reject",consumes = "application/json")
	public String rejectsAssetOrder(@PathVariable long id ,@RequestBody ObjectNode object) throws NoAuthority, InvalidOrderId, InvalidEmployeeId{
		long orderId = object.get("orderId").asLong();
		return empService.rejectOrder(id,orderId);
		
	}
	//get allocate order ticket
	@GetMapping(path = "/{id}/orders/Allocated")
	public List<Ticket> showAllocateRequest(@PathVariable("id")long id) throws InvalidEmployeeId, NoAuthority ,NoOrderFound{
		return empService.showAllPendingOrder(id);
	}
		//Release order
	@PutMapping(path="/{id}/order/release",consumes = "application/json")
	public String RereleaseOrders(@PathVariable long id ,@RequestBody ObjectNode object) throws NoAuthority ,InvalidOrderId, InvalidEmployeeId{
		long orderId =  object.get("orderId").asLong();
		return empService.releaseOrder(id,orderId);
	}
	//Employee Add
	@PostMapping(path ="/{id}/addemp")
	public String createEmployee(@PathVariable("id") long id ,@RequestBody Employee emp) throws NoAuthority, InvalidEmployeeId {
		return empService.addEmployee(id, emp);
	}
	//Employee update
	@PutMapping(path ="/{id}/updateemp",consumes = "application/json")
	public String updateCompanyEmployee(@PathVariable("id") long id ,@RequestBody Employee emp) throws NoAuthority, InvalidEmployeeId{
		return empService.updateEmployee(id, emp);
	}
	//Delete Employee
	@DeleteMapping(path ="/{id}/deleteemp",consumes = "application/json")
	public String deleteCompanyEmployee(@PathVariable("id") long id ,@RequestBody ObjectNode object) throws NoAuthority, InvalidEmployeeId{
		long empId = object.get("empId").asLong();
		return empService.deleteEmployee(id, empId);
	}
	
	//show all assets
	@GetMapping(path = "/{id}/asset/allasset")
	public List<Assets> showAllAsset(@PathVariable("id") long id) throws InvalidEmployeeId, NoAssetsFound {
		return empService.showAllAssetDetails(id);
	}
	
	//add asset
	@PostMapping(path = "/{id}/asset/add",consumes = "application/json")
	public String addNewAsset(@PathVariable("id") long id,@RequestBody Assets asset) throws NoAuthority, DuplicateAsset, InvalidEmployeeId {
		return empService.addAsset(id, asset);
	}
	
	//update the asset
	@PutMapping(path = "/{id}/asset/update",consumes = "application/json")
	public String updateNewAsset(@PathVariable("id") long id,@RequestBody Assets asset) throws NoAuthority, InvalidAssetId, InvalidEmployeeId {
		return empService.updateAsset(id, asset);
	}
	
	//delete
	@DeleteMapping(path = "/{id}/asset/delete",consumes = "application/json")
	public String deleteAsset(@PathVariable("id") long id,@RequestBody ObjectNode object) throws NoAuthority, InvalidAssetId, InvalidEmployeeId {
		long assetId = object.get("assetId").asLong();
		return empService.deleteAsset(id,assetId);
	}
	
	
	
}
