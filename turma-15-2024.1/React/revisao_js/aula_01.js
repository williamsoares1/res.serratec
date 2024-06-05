var frase = "Eu amo Java! S2"
frase.length
var fraseAlt = frase.replace("Java", "JavaScrpit")

var converterInteiro = parseInt('10', 10)
var converterFLoat = parseFloat('10.1234')

var numero = 2000
var numeroCasasDecimais = numero.toFixed(2)

const mengaoEhOMelhorDoRio = true
const euTenhoCertezaDaAfirmacaoAcima = false

var indefinido = undefined
var nulo = null

// funcoes declarativas
function soma(num1, num2){
    return num1 + num2
}

// funcoes atribuidas
const subtracao = function(num1, num2){
    return num1 - num2
}

// funcoes anonimas
var calculos = {
    subtracao: function(num1, num2){
        return num1 - num2
    },
    adicao: function(num1, num2){
        return num1 + num2
    }
}

// arrow functions
var adicao = (a, b) => a + b;

var quadrado = x => x * x;

var apresentacao = (nome) => {
    console.log(`Olá ${nome}, Seja bem vindo! :D`)
};

//Objeto
var aluno = {
    nome: "William",
    idade: 19,
    curso: "Serratec",
    time: "Flamengo",
    cidade: "Teresópolis",
    saudar: () => console.log("Olá, me chamo William!")
}

//Uso de objeto
var pessoa1 = {
    nome: "Pessoa Um",
    idade: 20,
    cidade: "Teresópolis RJ",
    rico: true
}

var pessoa2 = {
    nome: "Pessoa Dois",
    idade: 44,
    cidade: "Petropolis RJ"
}

function exibirDados({nome, idade, cidade, rico}){
    console.log(`Olá ${nome}, Seja bem vindo!`)
    console.log(`Sua idade é de ${idade} anos`)
    console.log(`Você mora em ${cidade}`)

    if(rico)
        console.log(`Você é rico`)
}

// exibirDados(pessoa1)
// exibirDados(pessoa2)

//Manipulando arrays

var meuArray = ["Portugol", "Java", "React"]
var meuArray = ["React", 0, 12.77, {nome: "William", idade: 19}, true, (n1, n2) => n1 + n2]

/*
.length = Permite ver o comprimento do array
.join(",") = Junta todos os elementos do array em uma String
.pop() = Remove o ultimo elemento do array
.shift() = Remove o primeiro elemento do array
.push() = Adiciona um elemento ao final do array
.indexOf() = Localiza um elemento no array
.find() = Localiza um elemento no array
*/


//apelidos
const nomes = ["William", "Pessoa 1", "Pessoa 2", "Gorda"]

const [eu, pessoax, pessoay, gata] = nomes
// const [euMemo, , ,minhaGata] = nomes

const teste = () => {
    return [1, 2]
}

const [result1, result2] = teste()

//iteracao de array e objeto
var arr1 = [1, 2, 3, 4]
var arr2 = [5, 6, 7, 8]

//em memoria, o string é uma array
var a = "William"

var arr3 = [...arr1, ...arr2, ...a]

var pessoa3 = {
    nome: "Pessoa 3",
    tel: "2222222222",
    icq: 123456783
}

var pessoa4 = {
    nome: "Pessoa 4",
    tel: "12345678765"
}

var total = {...pessoa3, ...pessoa4}

const saudacao = ({nome, tel, ...resto}) => {
    console.log(nome)
    console.log(tel)

    console.log(resto)
}

// saudacao(pessoa3)
// saudacao(pessoa4)

const times = [
    {
        nome: 'flamengo',
        EhDoRio: true
    },
    {
        nome: 'fluminense',
        EhDoRio: true
    },
    {
        nome: 'vasco',
        EhDoRio: true
    },
    {
        nome: 'botafogo',
        EhDoRio: true
    },
    {
        nome: 'palmeiras',
        EhDoRio: false
    },
    {
        nome: 'sport',
        EhDoRio: false
    },
    {
        nome: 'cruzeiro',
        EhDoRio: false
    }
]

const timesCariocas = times.filter((element) => element.EhDoRio)
const outrosTimes = times.filter((element) => !element.EhDoRio)

console.log(timesCariocas)
console.log("\n\n")
console.log(outrosTimes)