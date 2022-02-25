function validate() {
    let name = document.getElementById("nameId").value;
    let price = document.getElementById("priceId").value;
    let quantiy = document.getElementById("quantityId").value;
    let mfDate = document.getElementById("mfDateId").value;
    let inspDate = document.getElementById("inspDateId").value;


    if (isBlank(name)) {
        document.getElementById("nameMsg").innerHTML = "Enter name";
        document.getElementById("nameMsg").style.color = "red";
        return false;
    }

    if (isBlank(price)) {
        document.getElementById("priceMsg").innerHTML = "Enter price";
        document.getElementById("priceMsg").style.color = "red";
        return false;
    }

    if (isBlank(quantity)) {
        document.getElementById("quantityMsg").innerHTML = "Enter quantity";
        document.getElementById("quantityMsg").style.color = "red";
        return false;
    }

    if (isBlank(mfDate)) {
        document.getElementById("mfDateMsg").innerHTML = "Enter manufacture date";
        document.getElementById("mfDateMsg").style.color = "red";
        return false;
    }
    
    if (isBlank(inspDate)) {
        document.getElementById("inspDateMsg").innerHTML = "Enter inspected date";
        document.getElementById("inspDateMsg").style.color = "red";
        return false;
    }
 
    return true;
}
function isBlank(val) {
    return (val.trim() == "") ? true : false;
}