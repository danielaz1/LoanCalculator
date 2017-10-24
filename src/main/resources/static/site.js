var slider = document.getElementById("myRange");
var output = document.getElementById("sliderValue");
output.value = slider.value;

slider.oninput = function() {
    output.value = this.value;
}

var slider1= document.getElementById("myRange1");
var output1 = document.getElementById("sliderValue1");
output1.value = slider1.value;

slider1.oninput = function() {
    output1.value = this.value;
}