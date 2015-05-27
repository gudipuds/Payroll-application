
function validatecode() {

	var code = document.forms["empform"]["empCode"].value;
	var err1 = document.getElementById("empcode");
	var pattern =  "^[a-z A-Z]{3}[0-9]{3}$";
    if(code == "") {
    	
    	err1.innerHTML = "please enter the code "	;
 	    err1.style.color = "#FF0000";
 		document.forms["empform"]["empCode"].select();
	  
		return false;
	}
	else if(code.match(pattern)) {
		err1.innerHTML = "";
		return true;
	}
	else
		{
		err1.innerHTML = "Please enter the correct employee code:first three letters must be alphabets followed by 3 digits";
		err1.style.color = "#FF0000";
	    document.forms["empform"]["empCode"].select();
		return false;
		
		}
	
}
function validatelname() {
	
	var code = document.forms["empform"]["lastName"].value;
	
	var err1 = document.getElementById("lnamecode");
	
	var pattern = "[a-z A-Z]{5,10}"; 
	if(code == "") {
		
		err1.innerHTML="Please fill the last name";
		err1.style.color = "#FF0000";
		document.forms["empform"]["lastName"].select();
	
		return false;
	}
	else if(code.length > 15 || code.length <1) {
		err1.innerHTML = "please fill below 15 characters only";
		document.forms["empform"]["lastName"].select();
		return false;
	}
	else if(code.match(pattern)) {
		err1.innerHTML = "";
		return true;
	}
	else
		{
		err1.innerHTML = "Please enter only 5-10 alphabets " ;
		err1.style.color = "#FF0000";
		document.forms["empform"]["lastName"].select();
		return false;
		}
	
}

function middlename() {
	var code = document.forms["empform"]["middleName"].value;
	var err1 = document.getElementById("mnamecode");
	var pattern = "[a-z A-Z]{5,10}"; 
	if(code == "") {
		err1.innerHTML="Please fill the middle name";
		err1.style.color = "#FF0000";
		document.forms["empform"]["middleName"].select();
		
		return false;
	}
	else if(code.match(pattern)) {
		err1.innerHTML = "";
		return true;
	}
	else
		{
		err1.innerHTML = "Please enter only alphabets " ;
		err1.style.color = "#FF0000";
		document.forms["empform"]["middleName"].select();
		//document.forms["empform"]["middleName"].value = "";
		return false;
		}
	
}
function firstname() {
	var code = document.forms["empform"]["firstName"].value;
	var err1 = document.getElementById("fnamecode");
	var pattern = "[a-z A-Z]{5,10}"; 
	if(code == "") {
		err1.innerHTML="Please fill the first name";
		err1.style.color = "#FF0000";
		document.forms["empform"]["firstName"].focus();
		
		return false;
	}
	else if(code.match(pattern)) {
		err1.innerHTML = "";
		return true;
	}
	else
		{
		err1.innerHTML = "Please enter only alphabets " ;
		err1.style.color = "#FF0000";
		document.forms["empform"]["firstName"].select();
		//document.forms["empform"]["firstName"].value = "";
		return false;
		}
	
}

function title() {
	var code = document.forms["empform"]["title"].value;
	var err1 = document.getElementById("titlecode");
	var pattern = "[a-z A-Z]{5,10}"; 
	if(code == "") {
		err1.innerHTML="Please fill the title";
		err1.style.color = "#FF0000";
		document.forms["empform"]["title"].select();
		return false;
	}
	else if(code.match(pattern)) {
		err1.innerHTML = "";
		return true;
	}
	else
		{
		err1.innerHTML = "Please enter only alphabets " ;
		document.forms["empform"]["title"].select();
		//document.forms["empform"]["title"].value = "";
		
		return false;
		}
	
}

function birth() {
	var code = document.forms["empform"]["birthDate"].value;
	var err1 = document.getElementById("birthcode");
	
	if(code == "") {
		err1.innerHTML="Please fill the birthdate";
		err1.style.color = "#FF0000";
		document.forms["empform"]["birthDate"].focus();
		return false;
	}
	else 
		{
		err1.innerHTML = "";
		return true;
		
		}
		
	/*else if(code.match(pattern)) {
		err1.innerHTML = "";
		return true;
	}
	else
		{
		err1.innerHTML = "Please enter only 5-10 alphabets " ;
		document.forms["empform"]["birthDate"].select();
		//document.forms["empform"]["birthDate"].value = "";
		return false;
		}*/
	
}

function nationality() {
	var code = document.forms["empform"]["nationality"].value;
	var err1 = document.getElementById("nation");
	var pattern = "[a-z A-Z]{5,10}"; 
	if(code == "") {
		
		err1.innerHTML="Please fill the nationality";
		err1.style.color = "#FF0000";
		document.forms["empform"]["nationality"].select();
		return false;
	}
	else if(code.match(pattern)) {
		err1.innerHTML = "";
		return true;
	}
	else
		{
		//document.forms["empform"]["nationality"].value = "";
		err1.innerHTML = "Please enter only 5-10 alphabets " ;
		document.forms["empform"]["nationality"].select();
		
		return false;
		}
	
}

function addln1() {
	var code = document.forms["empform"]["addln1"].value;
	var err1 = document.getElementById("adress1");
	var pattern = "[a-z A-Z]{5,10}"; 
	if(code == "") {
		
		err1.innerHTML="Please fill the address1";
		err1.style.color = "#FF0000";
		document.forms["empform"]["addln1"].focus();
		return false;
	}
	else if(code.match(pattern)) {
		err1.innerHTML = "";
		return true;
	}
	else
		{
		//document.forms["empform"]["addln1"].value = "";
		err1.innerHTML = "Please enter only 5-10 alphabets " ;
		document.forms["empform"]["addln1"].select();
		return false;
		}
	
}

function addln2() {
	var code = document.forms["empform"]["addln2"].value;
	var err1 = document.getElementById("adress2");
	var pattern = "[a-z A-Z]{5,10}"; 
	if(code == "") {
		
		err1.innerHTML="Please fill the address2";
		err1.style.color = "#FF0000";
		document.forms["empform"]["addln2"].focus();
		return false;
	}
	else if(code.match(pattern)) {
		err1.innerHTML = "";
		return true;
	}
	else
		{
		//document.forms["empform"]["addln2"].value = "";
		err1.innerHTML = "Please enter only 5-10 alphabets " ;
		document.forms["empform"]["addln2"].select();
		return false;
		}
	
}

function town() {
	var code = document.forms["empform"]["town"].value;
	var err1 = document.getElementById("town");
	var pattern = "[a-z A-Z]{5,10}"; 
	if(code == "") {
		
		err1.innerHTML="Please fill the town";
		err1.style.color = "#FF0000";
		document.forms["empform"]["town"].select();
		return false;
	}
	else if(code.match(pattern)) {
		err1.innerHTML = "";
		return true;
	}
	else
		{
		
		//document.forms["empform"]["town"].value = "";
		err1.innerHTML = "Please enter only 5-10 alphabets " ;
		document.forms["empform"]["town"].select();
		return false;
		}
	
}

function state() {
	var code = document.forms["empform"]["state"].value;
	var err1 = document.getElementById("state");
	var pattern = "[a-z A-Z]{5,10}"; 
	if(code == "") {
		
		err1.innerHTML="Please fill the state";
		err1.style.color = "#FF0000";
		document.forms["empform"]["state"].select();
		return false;
	}
	else if(code.match(pattern)) {
		err1.innerHTML = "";
		return true;
	}
	else
		{
		//document.forms["empform"]["state"].value = "";
		err1.innerHTML = "Please enter correct state name " ;
		document.forms["empform"]["state"].select();
		return false;
		}
	
}
function postcode() {
	var code = document.forms["empform"]["postcode"].value;
	var err1 = document.getElementById("postcode");
	var pattern = "[0-9]{5,10}"; 
	if(code == "") {
		
		err1.innerHTML="Please fill the nationality";
		err1.style.color = "#FF0000";
		document.forms["empform"]["postcode"].select();
		return false;
	}
	else if(code.length != 6)
		{
		err1.innerHTML="postcode must be of length 6 only";
		}
	else if(code.match(pattern)) {
		err1.innerHTML = "";
		return true;
	}
	else
		{
		//document.forms["empform"]["nationality"].value = "";
		err1.innerHTML = "Please enter only digits" ;
		document.forms["empform"]["postcode"].select();
		return false;
		}
	
}

function phone() {
	var code = document.forms["empform"]["phone"].value;
	var err1 = document.getElementById("phone");
	var pattern = "[0-9]{5,10}"; 
	if(code == "") {
		err1.innerHTML="Please fill the phone number";
		err1.style.color = "#FF0000";
		document.forms["empform"]["phone"].select();
		return false;
	}
	else if(code.match(pattern)) {
		err1.innerHTML = "";
		return true;
	}
	else
		{
		//document.forms["empform"]["nationality"].value = "";
		err1.innerHTML = "Please enter only digits " ;
		document.forms["empform"]["phone"].select();
		
		return false;
		}
	
}









