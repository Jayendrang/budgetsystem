// Login action

function showExpensesPage(){
	expenseAddElement(true);
}
function showIncomePage(){
	incomeAddElement(true);
}

// Home page actions
// Get the Sidebar
var mySidebar = document.getElementById("mySidebar");

// Get the DIV with overlay effect
var overlayBg = document.getElementById("myOverlay");

// Toggle between showing and hiding the sidebar, and add overlay effect
function w3_open() {
    if (mySidebar.style.display === 'block') {
        mySidebar.style.display = 'none';
        overlayBg.style.display = "none";
    } else {
        mySidebar.style.display = 'block';
        overlayBg.style.display = "block";
    }
}

// Close the sidebar with the close button
function w3_close() {
    mySidebar.style.display = "none";
    overlayBg.style.display = "none";
}

// Expenses page actions
//Click on a close button to hide the current list item
var expense_close = document.getElementsByClassName("expense-close");
var expense_x=expense_close.length;
var expense_dateFieldsList = document.getElementsByClassName("expense-date");
var expense_typeFieldsList = document.getElementsByClassName("expense-type");
var expense_descFieldsList = document.getElementsByClassName("expense-desc");
var expense_amtFieldsList = document.getElementsByClassName("expense-amount");
var expense_remarksFieldsList = document.getElementsByClassName("expense-remarks");

for(var expense_a=0;expense_a<expense_typeFieldsList.length;expense_a++){
	var expense_select = expense_typeFieldsList[expense_a];
	for(var expense_b=0;expense_b<expense_expenseList.length;expense_b++){
		expense_select.options[expense_select.options.length] = new Option(expense_expenseList[expense_b], expense_expenseList[expense_b]);
	}
}
for (var expense_i = 0; expense_i < expense_close.length; expense_i++) {
  expense_close[expense_i].onclick = function() {
    var expense_div = this;
	expense_div.parentNode.parentNode.parentNode.removeChild(expense_div.parentNode.parentNode);
	for (var expense_j = 0; expense_j < expense_dateFieldsList.length; expense_j++) {
		var expense_dateElem = expense_dateFieldsList[expense_j];
		var expense_typeElem = expense_typeFieldsList[expense_j];
		var expense_descElem = expense_descFieldsList[expense_j];
		var expense_amtElem = expense_amtFieldsList[expense_j];
		var expense_remarksElem = expense_remarksFieldsList[expense_j];
		expense_dateElem.id = "expense-date"+(expense_j+1);
		expense_typeElem.id = "expense-dropdown"+(expense_j+1);
		expense_descElem.id = "expense-desc"+(expense_j+1);
		expense_amtElem.id = "expense-amount"+(expense_j+1);
		expense_remarksElem.id = "expense-remarks"+(expense_j+1);
	}
  }
}

// Create a new list item when clicking on the "+" button

function expenseAddElement(isExpenseFirstElement){
  if(isExpenseFirstElement){
	expense_x=0;
  }
  else{
	expense_x=expense_close.length;
  }
  expense_x++;
  var expense_elemContent = '<tr><td><input id="expense-date'+ expense_x +'" type="date" class="expense-date" name="expense-date-value"></td><td><select id="expense-dropdown'+ expense_x +'" name="expenses_category" class="expense-type"></select></td><td><textarea id="expense-desc'+ expense_x +'" class="expense-desc" name="expense-desc" form="expense-input">Enter description here...</textarea></td><td><input id="expense-amount'+ expense_x +'" class="expense-amount" type="text" name="expense-amt"></td><td><textarea class="expense-remarks" id="expense-remarks'+ expense_x +'" name="remarks" form="expense-input">Enter remarks here...</textarea></td><td class="expense-operations-field"><span class="expense-close">X</span><span class="expense-add">+</span></td></tr>';
  var expense_expenseTable = document.getElementById('expense-table');
  if(isExpenseFirstElement){
	expense_expenseTable.innerHTML = '<tr><th>Date</th><th>Expense Type</th><th>Expense Description</th><th>Expense Amount</th><th>Remarks</th><th></th></tr>';
  }
  expense_expenseTable.insertAdjacentHTML('beforeend', expense_elemContent);
  
  var expense_addList = document.querySelectorAll("span.expense-add");
  if(expense_addList.length>1){
	for (var expense_k = 0; expense_k < ((expense_addList.length)-1); expense_k++) {
	  var expense_elem = expense_addList[expense_k];
	  expense_elem.parentNode.removeChild(expense_elem);
	}  
  }
  var expense_selectVal = document.getElementById('expense-dropdown'+expense_x);
  for(var expense_d=0;expense_d<expense_expenseList.length;expense_d++){
	expense_selectVal.options[expense_selectVal.options.length] = new Option(expense_expenseList[expense_d], expense_expenseList[expense_d]);
  }

  for (var expense_l = 0; expense_l < expense_close.length; expense_l++) {
    expense_close[expense_l].onclick = function() {
		expense_x=expense_close.length;
		var expense_div1 = this;
		expense_div1.parentNode.parentNode.parentNode.removeChild(expense_div1.parentNode.parentNode);
		expense_dateFieldsList = document.getElementsByClassName("expense-date");
		expense_typeFieldsList = document.getElementsByClassName("expense-type");
		expense_descFieldsList = document.getElementsByClassName("expense-desc");
		expense_amtFieldsList = document.getElementsByClassName("expense-amount");
		expense_remarksFieldsList = document.getElementsByClassName("expense-remarks");
		for (var expense_m = 0; expense_m < dateFieldsList.length; expense_m++) {
			var expense_dateElem = expense_dateFieldsList[expense_m];
			var expense_typeElem = expense_typeFieldsList[expense_m];
			var expense_descElem = expense_descFieldsList[expense_m];
			var expense_amtElem = expense_amtFieldsList[expense_m];
			var expense_remarksElem = expense_remarksFieldsList[expense_m];
			expense_dateElem.id = "expense-date"+(expense_m+1);
			expense_typeElem.id = "expense-dropdown"+(expense_m+1);
			expense_descElem.id = "expense-desc"+(expense_m+1);
			expense_amtElem.id = "expense-amount"+(expense_m+1);
			expense_remarksElem.id = "expense-remarks"+(expense_m+1);
		}
    }
  }
  
  document.querySelector("span.expense-add").onclick = function() {
	expenseAddElement(false);
  }

}


//Income page actions
//Click on a close button to hide the current list item
var income_close = document.getElementsByClassName("income-close");
var income_x=income_close.length;
var income_dateFieldsList = document.getElementsByClassName("income-date");
var income_typeFieldsList = document.getElementsByClassName("income-type");
var income_descFieldsList = document.getElementsByClassName("income-desc");
var income_amtFieldsList = document.getElementsByClassName("income-amount");
var income_remarksFieldsList = document.getElementsByClassName("income-remarks");

for(var income_a=0;income_a<income_typeFieldsList.length;income_a++){
	var income_select = income_typeFieldsList[income_a];
	for(var income_b=0;income_b<income_expenseList.length;income_b++){
		income_select.options[income_select.options.length] = new Option(income_expenseList[income_b], income_expenseList[income_b]);
	}
}
for (var income_i = 0; income_i < income_close.length; income_i++) {
  income_close[income_i].onclick = function() {
    var income_div = this;
	income_div.parentNode.parentNode.parentNode.removeChild(income_div.parentNode.parentNode);
	for (var income_j = 0; income_j < income_dateFieldsList.length; income_j++) {
		var income_dateElem = income_dateFieldsList[income_j];
		var income_typeElem = income_typeFieldsList[income_j];
		var income_descElem = income_descFieldsList[income_j];
		var income_amtElem = income_amtFieldsList[income_j];
		var income_remarksElem = income_remarksFieldsList[income_j];
		income_dateElem.id = "income-date"+(income_j+1);
		income_typeElem.id = "income-dropdown"+(income_j+1);
		income_descElem.id = "income-desc"+(income_j+1);
		income_amtElem.id = "income-amount"+(income_j+1);
		income_remarksElem.id = "income-remarks"+(income_j+1);
	}
  }
}

// Create a new list item when clicking on the "+" button

function incomeAddElement(isIncomeFirstElement){
  if(isIncomeFirstElement){
	income_x=0;  
  }
  else{
	income_x=income_close.length;
  }
  income_x++;
  var income_elemContent = '<tr><td><input id="income-date'+ income_x +'" type="date" class="income-date" name="income-date-value"></td><td><select id="income-dropdown'+ income_x +'" class="income-type" name="income_category"></select></td><td><textarea id="income-desc'+ income_x +'" class="income-desc" name="income-desc" form="income-input">Enter description here...</textarea></td><td><input id="income-amount'+ income_x +'" class="income-amount" type="text" name="income-amt"></td><td><textarea class="income-remarks" id="income-remarks'+ income_x +'" name="remarks" form="income-input">Enter remarks here...</textarea></td><td class="income-operations-field"><span class="income-close">X</span><span class="income-add">+</span></td></tr>';
  var income_expenseTable = document.getElementById('income-table');
  if(isIncomeFirstElement){
	income_expenseTable.innerHTML = '<tr><th>Date</th><th>Income Type</th><th>Income Description</th><th>Income Amount</th><th>Remarks</th><th></th></tr>';
  }
  income_expenseTable.insertAdjacentHTML('beforeend', income_elemContent);
  
  var income_addList = document.querySelectorAll("span.income-add");
  if(income_addList.length>1){
	for (var income_k = 0; income_k < ((income_addList.length)-1); income_k++) {
	  var income_elem = income_addList[income_k];
	  income_elem.parentNode.removeChild(income_elem);
	}  
  }
  var income_selectVal = document.getElementById('income-dropdown'+income_x);
  for(var income_d=0;income_d<income_expenseList.length;income_d++){
	income_selectVal.options[income_selectVal.options.length] = new Option(income_expenseList[income_d], income_expenseList[income_d]);
  }

  for (var income_l = 0; income_l < income_close.length; income_l++) {
    income_close[income_l].onclick = function() {
		income_x=income_close.length;
		var income_div1 = this;
		income_div1.parentNode.parentNode.parentNode.removeChild(income_div1.parentNode.parentNode);
		income_dateFieldsList = document.getElementsByClassName("income-date");
		income_typeFieldsList = document.getElementsByClassName("income-type");
		income_descFieldsList = document.getElementsByClassName("income-desc");
		income_amtFieldsList = document.getElementsByClassName("income-amount");
		income_remarksFieldsList = document.getElementsByClassName("income-remarks");
		for (var income_m = 0; income_m < income_dateFieldsList.length; income_m++) {
			var income_dateElem = income_dateFieldsList[income_m];
			var income_typeElem = income_typeFieldsList[income_m];
			var income_descElem = income_descFieldsList[income_m];
			var income_amtElem = income_amtFieldsList[income_m];
			var income_remarksElem = income_remarksFieldsList[income_m];
			income_dateElem.id = "income-date"+(income_m+1);
			income_typeElem.id = "income-dropdown"+(income_m+1);
			income_descElem.id = "income-desc"+(income_m+1);
			income_amtElem.id = "income-amount"+(income_m+1);
			income_remarksElem.id = "income-remarks"+(income_m+1);
		}
    }
  }
  
  document.querySelector("span.income-add").onclick = function() {
	incomeAddElement(false);
  }
}
