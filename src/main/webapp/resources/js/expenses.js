/**
 * 
 */
 var counter=1;
window.addEventListener("load",start,false);

function start(){
	document.getElementById("button").addEventListener("click",displayLocalStorage,false);
}

function displayLocalStorage(){	
	
	var x = document.getElementById("expenseName");
		var txt= x.length;
		var val= x.length;
		for (var i = 0; i < x.length; i++) {
				txt[i] = x[i].text ;
				val[i] = x[i].value;
			}	
	
	var table = document.getElementById("table");
		var name1="expensedate_0"+counter;
		var name2="expenseName_"+counter;
		var name3="expensedesc_"+counter;
		var name4="expenseamount_"+counter;
		var name5="expenseremark_"+counter;
		
		var tr = document.createElement("tr");
		var td1 = document.createElement("td");
		var td2 = document.createElement("td");
		var td3 = document.createElement("td");
		var td4 = document.createElement("td");
		var td5 = document.createElement("td");
		
		var input1 = document.createElement("input");
		input1.setAttribute("type","text");
		input1.setAttribute("name",name1);
		input1.setAttribute("data-date-format","yyyy-mm-dd");
		
		var input2 = document.createElement("select");
		input2.setAttribute("name",name2);
		var innerCounter=0;	
		var option = x.length;
		for(var i=0;i<x.length;i++){
				var tempName="input2_"+innerCounter;
				var option = document.createElement("option");
				option.setAttribute("name",tempName);
				option.setAttribute("value",val[i]);
				innerCounter++;
			}
			var input2_1 =document.createElement("option");
			
		var input3 = document.createElement("input");
		input3.setAttribute("type","text");
		input3.setAttribute("name",name3);
		
		var input4 = document.createElement("input");
		input4.setAttribute("type","text");
		input4.setAttribute("name",name4);
		
		var input5 = document.createElement("input");
		input5.setAttribute("type","text");
		input5.setAttribute("name",name5);
		input5.setAttribute("value",name5);
		
		
		
		td1.appendChild(input1);
		td2.appendChild(input2);
		td3.appendChild(input3);
		td4.appendChild(input4);
		td5.appendChild(input5);
		
		
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tr.appendChild(td4);
		tr.appendChild(td5);
			
		table.appendChild(tr);
		counter++;
		
}//end of function