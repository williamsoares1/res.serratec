
//EX 1
let frase = "Don't count your chickens before they hatch.";

function contarVogais(string) {
  let tFrase = string.toLowerCase();
  console.log(tFrase);

  let contador = 0;
  let naoV = 0;
  for (let i = 0; i < tFrase.length; i++) {
    let letra = tFrase.slice(i, i + 1);
    if (
      letra == "a" ||
      letra == "e" ||
      letra == "i" ||
      letra == "o" ||
      letra == "u"
    ) {
      contador++;
    } else {
      naoV++;
    }
  }

  console.log(`A frase inserida contem ${contador} vogais`);
}

contarVogais(frase);


//EX 4
function Palindromo() {
  let string = document.getElementById("string").value;
  let stringL = string.toLowerCase();
  let inverted = stringL.split("").reverse().join("");

  if (stringL != null && stringL == inverted) {
    alert(string + " é um palíndromo");
  } else {
    alert(string + " não é um palíndromo");
  }
}


//EX  5
const nome1 = "Gustavo"
      const nome2 = "Marcelo"

      console.log(nome1.concat(" ", nome2));
