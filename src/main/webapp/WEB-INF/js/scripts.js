function init(expenseList){
//Click on a close button to hide the current list item
var close = document.getElementsByClassName("close");
var x=close.length;
//var expenseList = ["Expense Types 1","Expense Types 2","Expense Types 3","Expense Types 4","Expense Types 5"];
var dateFieldsList = document.getElementsByClassName("expense-date");
var typeFieldsList = document.getElementsByClassName("expense-type");
var descFieldsList = document.getElementsByClassName("expense-desc");
var amtFieldsList = document.getElementsByClassName("expense-amount");
var remarksFieldsList = document.getElementsByClassName("expense-remarks");

for(var a=0;a<typeFieldsList.length;a++){
	var select = typeFieldsList[a];
	for(var b=0;b<expenseList.length;b++){
		select.options[select.options.length] = new Option(expenseList[b], b);
	}
}
for (var i = 0; i < close.length; i++) {
  close[i].onclick = function() {
    var div = this;
	div.parentNode.parentNode.parentNode.removeChild(div.parentNode.parentNode);
	for (var j = 0; j < dateFieldsList.length; j++) {
		var dateElem = dateFieldsList[j];
		var typeElem = typeFieldsList[j];
		var descElem = descFieldsList[j];
		var amtElem = amtFieldsList[j];
		var remarksElem = remarksFieldsList[j];
		dateElem.id = "date"+(j+1);
		typeElem.id = "dropdown"+(j+1);
		descElem.id = "desc"+(j+1);
		amtElem.id = "amount"+(j+1);
		remarksElem.id = "remarks"+(j+1);
	}
  }
}
}
// Create a new list item when clicking on the "+" button
document.querySelector("span.add").onclick = function() {
  addElement();
}

function addElement(){
  x=close.length;
  x++;
  var elemContent = '<tr><td><input id="date'+ x +'" type="date" class="expense-date" name="date-value"></td><td><select id="dropdown'+ x +'" class="expense-type"></select></td><td><textarea id="desc'+ x +'" class="expense-desc" name="expense-desc" form="expense-input">Enter description here...</textarea></td><td><input id="amount'+ x +'" class="expense-amount" type="text" name="expense-amt"></td><td><textarea class="expense-remarks" id="remarks'+ x +'" name="remarks" form="expense-input">Enter remarks here...</textarea></td><td class="operations-field"><span class="close">X</span><span class="add">+</span></td></tr>';
  var expenseTable = document.getElementById('expense-table');
  expenseTable.insertAdjacentHTML('beforeend', elemContent);
  
  var addList = document.querySelectorAll("span.add");
  if(addList.length>1){
	for (var k = 0; k < ((addList.length)-1); k++) {
	  var elem = addList[k];
	  elem.parentNode.removeChild(elem);
	}  
  }
  var selectVal = document.getElementById('dropdown'+x);
  for(var d=0;d<expenseList.length;d++){
	selectVal.options[selectVal.options.length] = new Option(expenseList[d], d);
  }

  for (var l = 0; l < close.length; l++) {
    close[l].onclick = function() {
		x=close.length;
		var div1 = this;
		div1.parentNode.parentNode.parentNode.removeChild(div1.parentNode.parentNode);
		dateFieldsList = document.getElementsByClassName("expense-date");
		typeFieldsList = document.getElementsByClassName("expense-type");
		descFieldsList = document.getElementsByClassName("expense-desc");
		amtFieldsList = document.getElementsByClassName("expense-amount");
		remarksFieldsList = document.getElementsByClassName("expense-remarks");
		for (var m = 0; m < dateFieldsList.length; m++) {
			var dateElem = dateFieldsList[m];
			var typeElem = typeFieldsList[m];
			var descElem = descFieldsList[m];
			var amtElem = amtFieldsList[m];
			var remarksElem = remarksFieldsList[m];
			dateElem.id = "date"+(m+1);
			typeElem.id = "dropdown"+(m+1);
			descElem.id = "desc"+(m+1);
			amtElem.id = "amount"+(m+1);
			remarksElem.id = "remarks"+(m+1);
		}
    }
  }
  
  document.querySelector("span.add").onclick = function() {
	addElement();
  }

}