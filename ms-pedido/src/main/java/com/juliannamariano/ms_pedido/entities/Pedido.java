package com.juliannamariano.ms_pedido.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 10)
    private String nome;
    @Column(nullable = false, length = 11)
    private String cpf;
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private Status status;

    // Relacionamento
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.PERSIST)
    private List<ItemDoPedido> itens = new ArrayList<>();

}
