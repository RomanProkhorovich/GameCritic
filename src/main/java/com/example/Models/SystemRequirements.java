package com.example.Models;

import lombok.Data;

@Data
public class SystemRequirements {
    private byte RAM;
    private int ROM;
    private String CPU;
    private String graphicCard;
    private String OS;
}
