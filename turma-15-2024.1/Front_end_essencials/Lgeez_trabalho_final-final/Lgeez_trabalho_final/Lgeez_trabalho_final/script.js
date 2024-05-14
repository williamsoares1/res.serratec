const produtos = [
  {
    imagem: "img\\Produtos\\1.png",
    nome: "Echo Dor- 3ª geração",
    descricao:
      "O Echo Dot é um smart speaker compacto e versátil que oferece som de alta qualidade e integração com dispositivos inteligentes.",
    categoria: ["Dispositivos Vestíveis", "Tecnologia de Controle Mental"],
    preco: 299.99,
  },
  {
    imagem: "img\\Produtos\\2.png",
    nome: "Fire TV Stick",
    descricao:
      "O Fire TV Stick simplifica a experiência de streaming com botões de ligar e desligar, volume e silenciar em um único controle remoto.",
    categoria: ["Armazenamento de Dados", "Hardware de Computador"],
    preco: 199.99,
  },
  {
    imagem: "img\\Produtos\\3.png",
    nome: "Kindle 10ª geração",
    descricao:
      "O Kindle 10ª geração é um e-reader com luz embutida ajustável, tela antirreflexo de 6 polegadas e capacidade de armazenamento de 8GB. Ideal para leituras confortáveis em qualquer ambiente! ",
    categoria: ["Casa Inteligente", "Termostatos Inteligentes"],
    preco: 129.99,
  },
  {
    imagem: "img\\Produtos\\7.png",
    nome: "Smartphone Xiaomi Redmi Note 8:",
    descricao:
      "O Xiaomi Redmi Note 8 é um smartphone Android completo com tela de 6.3 polegadas, câmera quádrupla e memória expansível",
    categoria: ["Tecnologia Automotiva", "Assistentes de Condução"],
    preco: 349.99,
  },
  {
    imagem: "img\\Produtos\\8.png",
    nome: "Smartwatch Mi Band 4, Xiaomi",
    descricao:
      "A Mi Band 4 é uma pulseira fitness da Xiaomi com display colorido, sensores para contagem de passos, batimentos cardíacos, monitoramento do sono e notificações do celular",
    categoria: ["Monitores de Computador", "Tecnologia de Jogos"],
    preco: 599.99,
  },
  {
    imagem: "img\\Produtos\\9.png",
    nome: "Smart TV LED, LG",
    descricao:
      "A Smart TV LED LG oferece uma experiência imersiva com qualidade de imagem, controle por voz e recursos inteligentes. ",
    categoria: ["Dispositivos Vestíveis", "Tecnologia de Controle Mental"],
    preco: 299.99,
  },
  {
    imagem: "img\\Produtos\\6.png",
    nome: "Câmera de Segurança, Intelbras",
    descricao:
      "As câmeras de segurança Intelbras oferecem soluções versáteis, desde modelos Wi-Fi até HDCVI e IP, para monitorar e proteger residências e empresas.",
    categoria: ["Armazenamento de Dados", "Hardware de Computador"],
    preco: 199.99,
  },
  {
    imagem: "img\\Produtos\\5.png",
    nome: "Smart Controle Universal",
    descricao:
      "O Smart Controle Universal é capaz de controlar todos os tipos de aparelhos que funcionam por infravermelho diretamente pelo celular ou comando de voz (Google Assistente e Alexa).",
    categoria: ["Casa Inteligente", "Termostatos Inteligentes"],
    preco: 129.99,
  },
  {
    imagem: "img\\Produtos\\4.png",
    nome: "Echo Show 5",
    descricao:
      "O Echo Show 5 é um smart display compacto com Alexa, som nítido e câmera para chamadas de vídeo",
    categoria: ["Tecnologia Automotiva", "Assistentes de Condução"],
    preco: 349.99,
  },
  {
    imagem: "img\\Produtos\\11.png",
    nome: "Cabo de força de três pinos",
    descricao:
      "O cabo de força de três pinos é amplamente utilizado em aparelhos eletrodomésticos, como computadores, televisores, geladeiras e micro-ondas",
    categoria: ["Monitores de Computador", "Tecnologia de Jogos"],
    preco: 599.99,
  },
  {
    imagem: "img\\Produtos\\10.png",
    nome: "NeuroWave Headset",
    descricao:
      "Um headset revolucionário que utiliza tecnologia de ondas cerebrais para controlar dispositivos eletrônicos com a mente. Experimente uma nova forma de interação com seus dispositivos favoritos.",
    categoria: ["Dispositivos Vestíveis", "Tecnologia de Controle Mental"],
    preco: 299.99,
  },
  {
    imagem: "img\\Produtos\\12.png",
    nome: "Cabo USB para impressora 2.0 AM/BM 3m preto 3302 Force-line BT",
    descricao:
      "O SSD mais rápido do mercado, alimentado por tecnologia de computação quântica. Experimente tempos de carregamento ultrarrápidos e desempenho incomparável em seu computador ou console de jogos.",
    categoria: ["Armazenamento de Dados", "Hardware de Computador"],
    preco: 29.99,
  },
  {
    imagem: "img\\Produtos\\13.png",
    nome: "Cabo HDMI",
    descricao:
      "O cabo HDMI é essencial para conectar dispositivos como TVs, monitores e PCs.",
    categoria: ["Casa Inteligente", "Termostatos Inteligentes"],
    preco: 129.99,
  },
  {
    imagem: "img\\Produtos\\15.png",
    nome: "Cabo Usb-c 1,5m Nylon Branco - Intelbras EUAC 15NB",
    descricao:
      "Um assistente de direção avançado equipado com IA que monitora seu comportamento ao volante, oferecendo sugestões em tempo real para uma condução mais segura e eficiente.",
    categoria: ["Tecnologia Automotiva", "Assistentes de Condução"],
    preco: 349.99,
  },
  {
    imagem: "img\\Produtos\\14.png",
    nome: "HyperSync Gaming Monitor",
    descricao:
      "Um monitor de jogos de alta performance com taxas de atualização ultrarrápidas e tecnologia HDR aprimorada. Desfrute de uma experiência de jogo imersiva como nunca antes.",
    categoria: ["Monitores de Computador", "Tecnologia de Jogos"],
    preco: 599.99,
  },
  {
    imagem: "img\\Produtos\\16.png",
    nome: "QuantumDrive SSD",
    descricao:
      "O SSD mais rápido do mercado, alimentado por tecnologia de computação quântica. Experimente tempos de carregamento ultrarrápidos e desempenho incomparável em seu computador ou console de jogos.",
    categoria: ["Armazenamento de Dados", "Hardware de Computador"],
    preco: 199.99,
  },
  {
    imagem: "img\\Produtos\\25.png",
    nome: "EcoSmart Thermostat",
    descricao:
      "Um termostato inteligente que aprende seus padrões de uso e otimiza automaticamente a temperatura de sua casa para economizar energia. Controle facilmente a temperatura de qualquer lugar através de seu smartphone.",
    categoria: ["Casa Inteligente", "Termostatos Inteligentes"],
    preco: 129.99,
  },
  {
    imagem: "img\\Produtos\\26.png",
    nome: "NeuraDrive Car Assistant",
    descricao:
      "Um assistente de direção avançado equipado com IA que monitora seu comportamento ao volante, oferecendo sugestões em tempo real para uma condução mais segura e eficiente.",
    categoria: ["Tecnologia Automotiva", "Assistentes de Condução"],
    preco: 349.99,
  },
  {
    imagem: "img\\Produtos\\17.png",
    nome: "Samsung Galaxy Z Flip3",
    descricao:
      "O Samsung Galaxy Z Flip3 é um celular dobrável com recursos inovadores",
    categoria: ["Monitores de Computador", "Tecnologia de Jogos"],
    preco: 599.99,
  },
  {
    imagem: "img\\Produtos\\18.png",
    nome: "SMART WATCH PRO",
    descricao:
      "O Samsung Galaxy Watch5 Pro é um smartwatch com navegação por GPS, bateria de longa duração e monitoramento de saúde avançado.",
    categoria: ["Dispositivos Vestíveis", "Tecnologia de Controle Mental"],
    preco: 3999.99,
  },
  {
    imagem: "img\\Produtos\\19.png",
    nome: "Headset Gamer Corsair Void Elite Wireless",
    descricao:
      "O Headset Gamer Corsair Void Elite Wireless é um fone de ouvido premium sem fio com som surround 7.1, drivers de áudio em neodímio de 50mm e confortáveis auriculares de malha de microfibra e viscoelástico",
    categoria: ["Armazenamento de Dados", "Hardware de Computador"],
    preco: 199.99,
  },
  {
    imagem: "img\\Produtos\\21.png",
    nome: "Kit Gamer Teclado Mouse Headphone Rgb",
    descricao:
      "O Kit Gamer Teclado Mouse Headphone RGB oferece periféricos essenciais para uma experiência de jogo completa.",
    categoria: ["Casa Inteligente", "Termostatos Inteligentes"],
    preco: 129.99,
  },
  {
    imagem: "img\\Produtos\\20.png",
    nome: "Kit Logitech - Teclado K120 + Mouse M100 + Webcam C505 HD",
    descricao:
      "O Kit Logitech inclui o Teclado K120, o Mouse M100 e a Webcam C505 HD. O teclado é resistente a derramamentos, o mouse é simples e pronto para uso, e a webcam oferece vídeo HD 720p e um microfone de longo alcance",
    categoria: ["Tecnologia Automotiva", "Assistentes de Condução"],
    preco: 349.99,
  },
  {
    imagem: "img\\Produtos\\22.png",
    nome: "Kit Gamer Spider",
    descricao:
      "O Kit Gamer Spider da Fortrek oferece uma combinação de teclado, mouse e headset para uma experiência completa de jogo.",
    categoria: ["Monitores de Computador", "Tecnologia de Jogos"],
    preco: 599.99,
  },
  {
    imagem: "img\\Produtos\\23.png",
    nome: "Smart TV 50(polegadas) UHD 4K Samsung",
    descricao:
      "A Smart TV 50 polegadas UHD 4K 50CU7700 da Samsung oferece imagens mais vivas e nítidas em 4K, além de recursos como o Samsung Gaming Hub e a Tela sem limites com Visual Livre de Cabos",
    categoria: ["Monitores de Computador", "Tecnologia de Jogos"],
    preco: 599.99,
  },
  {
    imagem: "img\\Produtos\\24.png",
    nome: "Câmera Segurança Bullet Infravermelho HDCVI Intelbras VHD Hd",
    descricao:
      "A Câmera Bullet Infravermelho HDCVI VHD 3530 B da Intelbras possui 5 MP de resolução, alcance IR de 30 metros e proteção IP67. Ideal para projetos desafiadores, captura imagens nítidas e detalhadas com sua alta resolução1.",
    categoria: ["Monitores de Computador", "Tecnologia de Jogos"],
    preco: 599.99,
  },
];

let carrinhoDOM = [];

const atualizarCarrinho = () => {
  if (localStorage.getItem("carrinho")) {

    let produtosJSON = JSON.parse(localStorage.getItem("carrinho"));

    produtosJSON.forEach((produtin) => {

      carrinhoDOM.push(produtin);

    });
  }
};

const adicionar = {

  produtosHTML: () => {

    let div = document.querySelector(".content-container");

    produtos.forEach((produto) => {
      let box = `<div
      class="col-12 themed-grid-col m-0 m-sm-2 my-2 col-md-5 col-xl-3 d-flex flex-column justify-content-between align-items-center rounded gap-2 p-2"
      id="produto"
    >
      <img src="${produto.imagem}" alt="#" />
      <div>
        <h5 class="nome-pdt">${produto.nome}</h5>
        <p>${produto.descricao}</p>
        <p>${produto.categoria}</p>
        <h3>R$ ${produto.preco}</h3>
        <div data-app="product.quantity">
          <span
            id="span_erro_carrinho"
            class="blocoAlerta"
            style="display: none"
            >Selecione uma opção para variação do produto</span
          >
          <label for="quantidade">Quantidade:</label>
          <input type="button" id="btn-menos" value="-" />
          <input
            id="quantidade"
            name="quantidade"
            class="text"
            size="1"
            type="text"
            maxlength="5"
          />
          <input type="button" id="btn-mais" value="+" />
          <button class="btn" id="btn-add">
            <img
              width="24"
              height="24"
              src="img/cart3.svg"
              alt="shopping-cart--v1"
            />
          </button>
        </div>
      </div>
    </div>`;

      if (div) div.innerHTML += box;
    });
  },
  carrinhoHTML: () => {
    atualizarCarrinho();

    let div = document.querySelector(".container-carrinho");

    let textTotal = document.querySelector(".text-total");

    let vlTotal = 0;

    carrinhoDOM.forEach((item) => {
      let box = `<div class="mb-3 card" style="max-width: 1000px; margin: 0 auto;">
      <div class="row g-0">
      <div class="col-md-4 d-flex justify-content-center align-items-center">
      <img src="${item.imagem}" alt="#" />
        </div>
        <div class="col-md-8">
          <div class="card-body">
            <h5 class="name">${item.nome}</h5>
            <h5>Quantidade: ${item.quantidade}</h5>
            <h5>Valor Unitario: R$ ${item.preco}</h5>
            <h2>Total: R$ ${item.total}</h2>
            <button class="btn btn-primary" id="btn-del">
              excluir do carrinho
            </button>
        </div>
      </div>
    </div>`;

      vlTotal += item.total;

      if (div) {
        div.innerHTML += box;

        textTotal.innerHTML = `<h1>TOTAL PEDIDO: R$ ${vlTotal.toFixed(2)}</h1>`;

        let btn = document.querySelector(".btn-confirmar");
        let info = document.querySelector(".info-carrinho")
      
        if(carrinhoDOM.length != 0){
          btn.classList.remove("d-none")
          info.classList.add("d-none")
        }
      }
    });
  },
};

adicionar.produtosHTML();
adicionar.carrinhoHTML();

let carrinho = [];

const arrays = {
  input: Array.from(document.querySelectorAll("#quantidade")),

  btnSo: Array.from(document.querySelectorAll("#btn-mais")),

  btnSu: Array.from(document.querySelectorAll("#btn-menos")),

  btnAdd: Array.from(document.querySelectorAll("#btn-add")),

  btnDel: Array.from(document.querySelectorAll("#btn-del")),

  produtosHTML: Array.from(document.querySelectorAll("#produto")),
};

const interacao = {
  inserirItemCarrinho: () => {
    arrays.btnAdd.forEach((btn, index) => {
      btn.addEventListener("click", (event) => {
        event.preventDefault();

        if (arrays.input[index].value >= 1) {
          arrays.produtosHTML[index].classList.add("adicionado");

          let produtoOBJ = {
            imagem: produtos[index].imagem,
            nome: produtos[index].nome,
            index: index,
            descricao: produtos[index].descricao,
            categoria: produtos[index].categoria,
            preco: produtos[index].preco,
            quantidade: +arrays.input[index].value,
            total: produtos[index].preco * arrays.input[index].value,
          };

          localStorage.setItem("produto", JSON.stringify(produtoOBJ));

          carrinho.push(produtoOBJ);

          localStorage.setItem("carrinho", JSON.stringify(carrinho));
        }

        arrays.input[index].value = 1;
      });
    });
  },
  excluirItemCarrinho: () => {
    arrays.btnDel.forEach((btn, index) => {
      btn.addEventListener("click", (event) => {
        event.preventDefault();

        let produtosJSON = JSON.parse(localStorage.getItem("carrinho"));

        produtosJSON.splice(index, 1);

        localStorage.setItem("carrinho", JSON.stringify(produtosJSON));

        location.reload();
      });
    });
  },
  quantidade: {
    aumentar: () => {
      arrays.btnSo.forEach((btn, index) => {
        arrays.input[index].value = 1;

        btn.addEventListener("click", (event) => {
          event.preventDefault();

          arrays.input[index].value++;
        });
      });
    },
    diminuir: () => {
      arrays.btnSu.forEach((btn, index) => {
        arrays.input[index].value = 1;

        btn.addEventListener("click", (event) => {
          event.preventDefault();

          if (arrays.input[index].value <= 1)
            console.log("Minimo de 1 produto.");
          else arrays.input[index].value--;
        });
      });
    },
  },
};

const validacao = {
  validateForm: () => {
    const name = document.getElementById("name").value;
    const cpf = document.getElementById("cpf").value;
    const phone = document.getElementById("phone").value;
    const email = document.getElementById("email").value;
    const address = document.getElementById("address").value;

    let isValid = true;

    if (name === "") {
      document.getElementById("nameError").innerText =
        "Por favor, insira seu nome.";
      isValid = false;
    } else {
      document.getElementById("nameError").innerText = "";
    }

    if (cpf === "" || !isValidCPF(cpf)) {
      document.getElementById("cpfError").innerText =
        "Por favor, insira um CPF válido.";
      isValid = false;
    } else {
      document.getElementById("cpfError").innerText = "";
    }

    if (phone === "" || !isValidPhone(phone)) {
      document.getElementById("phoneError").innerText =
        "Por favor, insira um telefone válido.";
      isValid = false;
    } else {
      document.getElementById("phoneError").innerText = "";
    }

    if (email === "" || !isValidEmail(email)) {
      document.getElementById("emailError").innerText =
        "Por favor, insira um email válido.";
      isValid = false;
    } else {
      document.getElementById("emailError").innerText = "";
    }

    if (address === "") {
      document.getElementById("addressError").innerText =
        "Por favor, insira seu endereço.";
      isValid = false;
    } else {
      document.getElementById("addressError").innerText = "";
    }

    return isValid;
  },

  isValidCPF: (cpf) => cpf.length === 11,

  isValidPhone: (phone) => phone.length >= 10 && phone.length <= 15,

  isValidEmail: (email) => {
    const re = /\S+@\S+\.\S+/;
    return re.test(email);
  },
};

const filtragem = () => {
  const contem = (element, text) =>
    element.innerText.toLowerCase().includes(text.toLowerCase());

  const inputSearch = document.getElementById("search-input");

  if(inputSearch){
    inputSearch.addEventListener("input", () => {
      const termoDeBusca = inputSearch.value.trim();
      const infoBox = document.querySelector(".info");
      
      infoBox.classList.add("d-none");
      arrays.produtosHTML.forEach((produto) => produto.classList.add("d-none"));
  
      const filtrados = arrays.produtosHTML.filter((produto) => {
      const nome = produto.querySelector(".nome-pdt");
  
        return contem(nome, termoDeBusca);
      });

      if(filtrados.length == 0){
        infoBox.classList.remove("d-none");
        return
      }
  
      const produtosFiltrados = filtrados;
  
      produtosFiltrados.forEach((produto) => produto.classList.remove("d-none"));
    });
  }
};

interacao.inserirItemCarrinho();
interacao.excluirItemCarrinho();
interacao.quantidade.aumentar();
interacao.quantidade.diminuir();
filtragem();
