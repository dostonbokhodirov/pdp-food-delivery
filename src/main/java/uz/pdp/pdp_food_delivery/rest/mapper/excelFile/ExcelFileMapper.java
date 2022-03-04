package uz.pdp.pdp_food_delivery.rest.mapper.excelFile;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import uz.pdp.pdp_food_delivery.rest.dto.excelFile.ExcelFileDto;
import uz.pdp.pdp_food_delivery.rest.dto.mealorder.MealOrderCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.mealorder.MealOrderDto;
import uz.pdp.pdp_food_delivery.rest.entity.MealOrder;
import uz.pdp.pdp_food_delivery.rest.entity.excelFile.ExcelFile;
import uz.pdp.pdp_food_delivery.rest.mapper.BaseMapper;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ExcelFileMapper extends BaseMapper {

    ExcelFileDto toDto(ExcelFile excelFile);

    List<ExcelFileDto> toDto(List<ExcelFile> excelFiles);

    ExcelFile toEntity(ExcelFileDto excelFileDto);

    List<ExcelFile> toEntity(List<ExcelFileDto> excelFileDots);


}
