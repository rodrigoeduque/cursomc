package br.com.rodrigoeduque.cursomcnelioalves;

import br.com.rodrigoeduque.cursomcnelioalves.categorias.model.Categoria;
import br.com.rodrigoeduque.cursomcnelioalves.categorias.repository.CategoriaRepository;
import br.com.rodrigoeduque.cursomcnelioalves.cidades.model.Cidade;
import br.com.rodrigoeduque.cursomcnelioalves.cidades.repository.CidadeRepository;
import br.com.rodrigoeduque.cursomcnelioalves.clientes.enums.TipoCliente;
import br.com.rodrigoeduque.cursomcnelioalves.clientes.model.Cliente;
import br.com.rodrigoeduque.cursomcnelioalves.clientes.repository.ClienteRepository;
import br.com.rodrigoeduque.cursomcnelioalves.enderecos.model.Endereco;
import br.com.rodrigoeduque.cursomcnelioalves.enderecos.repository.EnderecoRepository;
import br.com.rodrigoeduque.cursomcnelioalves.estados.model.Estado;
import br.com.rodrigoeduque.cursomcnelioalves.estados.repository.EstadoRepository;
import br.com.rodrigoeduque.cursomcnelioalves.itempedido.model.ItemPedido;
import br.com.rodrigoeduque.cursomcnelioalves.itempedido.repository.ItemPedidoRepository;
import br.com.rodrigoeduque.cursomcnelioalves.pagamentos.PagamentoRepository;
import br.com.rodrigoeduque.cursomcnelioalves.pagamentos.model.EstadoPagamento;
import br.com.rodrigoeduque.cursomcnelioalves.pagamentos.model.Pagamento;
import br.com.rodrigoeduque.cursomcnelioalves.pagamentos.model.PagamentoComBoleto;
import br.com.rodrigoeduque.cursomcnelioalves.pagamentos.model.PagamentoComCartao;
import br.com.rodrigoeduque.cursomcnelioalves.pedidos.model.Pedido;
import br.com.rodrigoeduque.cursomcnelioalves.pedidos.repository.PedidoRepository;
import br.com.rodrigoeduque.cursomcnelioalves.produtos.model.Produto;
import br.com.rodrigoeduque.cursomcnelioalves.produtos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Set;

@SpringBootApplication
public class CursomcnelioalvesApplication implements CommandLineRunner {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public static void main(String[] args) {
        SpringApplication.run(CursomcnelioalvesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria("Inform??tica");
        Categoria cat2 = new Categoria("Escrit??rio");
        Categoria cat3 = new Categoria("Cama | Mesa | Banho");
        Categoria cat4 = new Categoria("Eletr??nicos");
        Categoria cat5 = new Categoria("Jardinagem");
        Categoria cat6 = new Categoria("Decora????o");
        Categoria cat7 = new Categoria("Perfurm??ria");
        Categoria cat8 = new Categoria("Celulares");
        Categoria cat9 = new Categoria("Acess??rios");

        Produto p1 = new Produto("Computador", 2000.00);
        Produto p2 = new Produto("Impressora", 800.00);
        Produto p3 = new Produto("Mouse", 80.00);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        Estado est1 = new Estado("Minas Gerais");
        Estado est2 = new Estado("S??o Paulo");

        Cidade c1 = new Cidade("Uberlandia", est1);
        Cidade c2 = new Cidade("S??o Paulo", est2);
        Cidade c3 = new Cidade("Campinas", est2);

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2, c3));

        Cliente cli1 = new Cliente("Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOA_FISICA);
        Endereco e1 = new Endereco("Rua Flores", "300", "Apto 203", "Jardim", "38220834", cli1, c1);
        Endereco e2 = new Endereco("Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);

        cli1.getTelefones().addAll(Set.of("2736114585", "34992648188"));
        cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

        String strLocalDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));


        Pedido ped1 = new Pedido(cli1, e1);
        Pedido ped2 = new Pedido(cli1, e2);

        Pagamento pagto1 = new PagamentoComCartao(EstadoPagamento.QUITADO, ped1, 6);
        ped1.setPagamento(pagto1);
        Pagamento pagto2 = new PagamentoComBoleto(EstadoPagamento.PENDENTE, ped2, LocalDate.of(2021, 10, 20), null);
        ped2.setPagamento(pagto2);

        cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

        ItemPedido ip1 = new ItemPedido(ped1, p1, 0.0, 1, 2000.00);
        ItemPedido ip2 = new ItemPedido(ped1, p3, 0.0, 2, 80.00);
        ItemPedido ip3 = new ItemPedido(ped2, p2, 100.0, 1, 800.00);

        ped1.getItens().addAll(Arrays.asList(ip1, ip2));
        ped2.getItens().addAll(Arrays.asList(ip3));

        p1.getItens().addAll(Arrays.asList(ip1));
        p2.getItens().addAll(Arrays.asList(ip3));
        p3.getItens().addAll(Arrays.asList(ip2));


        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
        clienteRepository.save(cli1);
        enderecoRepository.saveAll(Arrays.asList(e1, e2));
        pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
        pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
        itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
    }
}
