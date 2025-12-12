package com.leonardoteixeiraa.carros_tabela_fipe.dto;

import java.util.List;

public record ModelosResponseDTO(List<ModeloDTO> modelos, List<AnoDTO> anos) {
}
