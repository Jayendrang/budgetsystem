<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!doctype html>

<html lang="en">
<head>
  <meta charset="utf-8">

  <title>income predictor</title>
  <meta name="description" content="income predictor">

  <!-- <link rel="stylesheet" href="/budgetsystem/webapp/WEB-INF/css/styles.css?v=1.0">
  <link href="/src/css/styles.css" rel="stylesheet" type="text/css">-->
  <style>
  	body {
  margin: 20px;
  min-width: 250px;
}

/* Include the padding and border in an element's total width and height */
* {
  box-sizing: border-box;
}

/* Remove margins and padding from the list */
ul {
  margin: 0;
  padding: 0;
}

/* Style the list items */
ul li {
  cursor: pointer;
  position: relative;
  padding: 12px 8px 12px 40px;
  list-style-type: none;
  background: #eee;
  font-size: 18px;
  transition: 0.2s;
  
  /* make the list items unselectable */
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

/* Set all odd list items to a different color (zebra-stripes) */
ul li:nth-child(odd) {
  background: #f9f9f9;
}

/* Darker background-color on hover */
ul li:hover {
  background: #ddd;
}

/* Style the close button */
.close {
  position: relative;
  left: 20%;
  top: 4%;
  padding: 1px 16px 2px 16px;
  font-size: 22px;
  cursor:pointer;
}

/* Style the + button */
.add {
  position: relative;
  left: 25%;
  top: 4%;
  padding: 1px 16px 2px 16px;
  font-size: 35px;
  cursor:pointer;
}

/* Style the input */
input {
  border: none;
  width: 75%;
  padding: 10px;
  float: left;
  font-size: 16px;
}
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
	width:17%;
}
  </style>
 
</head>

<body>
	<form id="income-input"  action="${pageContext.request.contextPath}/income/addIncome" method="POST">
	<% String[] values=(String[])request.getAttribute("applicationdata"); %>
         <table id="income-table">
            <tr>
               <th>Date</th>
               <th>Income Type</th>
               <th>Income Description</th>
               <th>Income Amount</th>
			   <th>Remarks</th>
               <th></th>
            </tr>
			<tr>
				<td><input type="date" id="date1" class="income-date" type="date" name="date-value"></td>
				<td>
					<select id="dropdown1" name="income_category" class="income-type"/>
				</td>
				<td><textarea class="income-desc" id="desc1" name="income-desc" form="income-input">Enter description here...</textarea></td>
				<td><input type="text" class="income-amount" id="amount1"  name="income-amt"></td>
				<td><textarea class="income-remarks" id="remarks1" name="income-remarks" form="income-input">Enter remarks here...</textarea></td>
				<td class="operations-field">
					<span class="close">X</span>
					<span class="add">+</span>
				</td>
			</tr>
         </table>
         <input type="submit" name="AddIncome" value="Save Income" />
      </form>
  <!-- <script src="/budgetsystem/src/main/webapp/WEB-INF/js/scripts.js"></script>-->
   <script type="text/javascript">
   var expenseList = new Array();
   <%
   for (int j=0; j < values.length; j++) {
   %>
   expenseList[<%= j %>] = '<%=values[j].toString().trim() %>';
   <%}%>
   
	
	
   </script>
   
  
  <script type="text/javascript">
  
  
	//Click on a close button to hide the current list item
	var close = document.getElementsByClassName("close");
	var x=close.length;
	
	var dateFieldsList = document.getElementsByClassName("income-date");
	var typeFieldsList = document.getElementsByClassName("income-type");
	var descFieldsList = document.getElementsByClassName("income-desc");
	var amtFieldsList = document.getElementsByClassName("income-amount");
	var remarksFieldsList = document.getElementsByClassName("income-remarks");

	for(var a=0;a<typeFieldsList.length;a++){
		var select = typeFieldsList[a];
		for(var b=0;b<expenseList.length;b++){
			select.options[select.options.length] = new Option(expenseList[b], expenseList[b]);
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

  
	// Create a new list item when clicking on the "+" button
	document.querySelector("span.add").onclick = function() {
	  addElement();
	}

	function addElement(){
	  x=close.length;
	  x++;
	  var elemContent = '<tr><td><input id="date'+ x +'" type="date" class="income-date" name="date-value"></td><td><select id="dropdown'+ x +'" name="income_category" class="income-type"></select></td><td><textarea id="desc'+ x +'" class="income-desc" name="income-desc" form="income-input">Enter description here...</textarea></td><td><input id="amount'+ x +'" class="income-amount" type="text" name="income-amt"></td><td><textarea class="income-remarks" id="remarks'+ x +'" name="remarks" form="expense-input">Enter remarks here...</textarea></td><td class="operations-field"><span class="close">X</span><span class="add">+</span></td></tr>';
	  var expenseTable = document.getElementById('income-table');
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
		selectVal.options[selectVal.options.length] = new Option(expenseList[d], expenseList[d]);
	  }

	  for (var l = 0; l < close.length; l++) {
	    close[l].onclick = function() {
			x=close.length;
			var div1 = this;
			div1.parentNode.parentNode.parentNode.removeChild(div1.parentNode.parentNode);
			dateFieldsList = document.getElementsByClassName("income-date");
			typeFieldsList = document.getElementsByClassName("income-type");
			descFieldsList = document.getElementsByClassName("income-desc");
			amtFieldsList = document.getElementsByClassName("income-amount");
			remarksFieldsList = document.getElementsByClassName("income-remarks");
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
  </script>
</body>
</html>