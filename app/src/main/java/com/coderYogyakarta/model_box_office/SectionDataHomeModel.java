package com.coderYogyakarta.model_box_office;

import java.util.ArrayList;

public class SectionDataHomeModel {
    private String headerTitle;
    private ArrayList<SingleContentHomeModel> allContentSection;
    public SectionDataHomeModel(){

    }

    public SectionDataHomeModel(String headerTitle, ArrayList<SingleContentHomeModel> allContentSection) {
        this.headerTitle = headerTitle;
        this.allContentSection = allContentSection;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<SingleContentHomeModel> getAllContentSection() {
        return allContentSection;
    }

    public void setAllContentSection(ArrayList<SingleContentHomeModel> allContentSection) {
        this.allContentSection = allContentSection;
    }
}
