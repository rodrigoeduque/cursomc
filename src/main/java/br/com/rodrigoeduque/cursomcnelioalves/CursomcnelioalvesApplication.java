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
import br.com.rodrigoeduque.cursomcnelioalves.produtos.model.Produto;
import br.com.rodrigoeduque.cursomcnelioalves.produtos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

    public static void main(String[] args) {
        SpringApplication.run(CursomcnelioalvesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria("Informática");
        Categoria cat2 = new Categoria("Escritório");

        Produto p1 = new Produto("Computador", 2000.00);
        Produto p2 = new Produto("Impressora", 800.00);
        Produto p3 = new Produto("Mouse", 80.00);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        Estado est1 = new Estado("Minas Gerais");
        Estado est2 = new Estado("São Paulo");

        Cidade c1 = new Cidade("Uberlandia", est1);
        Cidade c2 = new Cidade("São Paulo", est2);
        Cidade c3 = new Cidade("Campinas", est2);

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2, c3));

        Cliente cli1 = new Cliente("Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOA_FISICA);
        Endereco e1 = new Endereco("Rua Flores", "300", "Apto 203", "Jardim", "38220834", cli1, c1);
        Endereco e2 = new Endereco("Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);

        cli1.getTelefones().addAll(Set.of("2736114585", "34992648188"));
        cli1.getEnderecos().addAll(Arrays.asList(e1, e2));


        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
        clienteRepository.save(cli1);
        enderecoRepository.saveAll(Arrays.asList(e1, e2));
    }
}
