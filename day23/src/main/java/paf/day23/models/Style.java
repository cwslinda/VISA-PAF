package paf.day23.models;


import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Style {

    private int styleId;
    private String styleName;
    

    public int getStyleId() { return styleId; }
    public void setStyleId(int styleId) { this.styleId = styleId; }
    
    public String getStyleName() { return styleName; }
    public void setStyleName(String styleName) { this.styleName = styleName; }
    
    public static Style create(SqlRowSet rs){
        final Style style = new Style();
        style.setStyleId(rs.getInt("id"));
        style.setStyleName(rs.getString("style_name"));
        return style;
    }



}
