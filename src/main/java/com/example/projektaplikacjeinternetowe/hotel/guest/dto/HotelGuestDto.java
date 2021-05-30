package com.example.projektaplikacjeinternetowe.hotel.guest.dto;

import com.example.projektaplikacjeinternetowe.hotel.commons.dto.AbstractDto;
import com.example.projektaplikacjeinternetowe.hotel.company.dto.CompanyDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
public class HotelGuestDto extends AbstractDto<Long> {

    private final static String phonePattern
            = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
            + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
            + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";

    @NotBlank(message = "Firstname cannot be empty")
    private String firstname;

    @NotBlank(message = "Firstname cannot be empty")
    private String secondName;

    @NotBlank(message = "Firstname cannot be empty")
    private String lastname;

    @NotNull
    private LocalDate dateOfBirth;

    @Pattern(regexp = phonePattern, message = "Invalid phone number")
    private String phoneNumber;

    @Email(message = "Invalid email")
    private String email;

    @NotNull
    private CompanyDto company;
}

