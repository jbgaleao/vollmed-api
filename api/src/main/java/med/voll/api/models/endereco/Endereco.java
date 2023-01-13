package med.voll.api.models.endereco;

import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(EnderecoDTO endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.uf = endereco.uf();
        this.cidade = endereco.cidade();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
    }

    public Endereco() {
    }

    public void atualizarEndereco(EnderecoDTO enderecoDTO) {
        if (this.logradouro != null) {
            this.logradouro = enderecoDTO.logradouro();
        }
        if (this.bairro != null) {
            this.bairro = enderecoDTO.bairro();
        }
        if (this.cep != null) {
            this.cep = enderecoDTO.cep();
        }
        if (this.uf != null) {
            this.uf = enderecoDTO.uf();
        }
        if (this.cidade != null) {
            this.cidade = enderecoDTO.cidade();
        }
        if (this.numero != null) {
            this.numero = enderecoDTO.numero();
        }
        if (this.complemento != null) {
            this.complemento = enderecoDTO.complemento();
        }
    }
}
