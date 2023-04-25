package com.taras.hotelsitebev2.dtos.roomdtos;

import com.taras.hotelsitebev2.dtos.DtoInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomsDto implements DtoInterface {

    private List<RoomsItem> rooms;

}
