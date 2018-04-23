window.addEventListener("load",function(){
	document.getElementById("addIncome").addEventListener("click",addButton,false);//end of add income button event listener
},false);//end of window event lietener

var counter=1;

function addButton(){
	var table= document.getElementById("table");
	
		var tr = document.createElement("tr");
		var td1 = document.createElement("td");
		var td2 = document.createElement("td");
		var td3 = document.createElement("td");
		var td4 = document.createElement("td");
		var td5 = document.createElement("td");
		
		var date="date_"+counter;
		var incomeName="incomeName_"+counter;
		var description="description_"+counter;
		var incomeAmount="incomeAmount_"+counter;
		var incomeRemarks="incomeRemarks_"+counter;
		
		var input1 = document.createElement("input");
		input1.setAttribute("type","date");
		input1.setAttribute("name",date);
		
		var input2 = document.createElement("select");
			var input2_option1 = document.createElement("option");
			input2_option1.innerHTML= document.getElementById("option1").innerHTML;
			var input2_option2 = document.createElement("option");
			input2_option2.innerHTML = document.getElementById("option2").innerHTML;
				input2.appendChild(input2_option1);
				input2.appendChild(input2_option2);
		
		var input3= document.createElement("textarea");
		input3.setAttribute("name",description);
		
		var input4 = document.createElement("input");
		input4.setAttribute("type","text");
		input4.setAttribute("name",incomeAmount);
		
		var input5 = document.createElement("input");
		input5.setAttribute("type","text");
		input5.setAttribute("name",incomeRemarks);
		
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