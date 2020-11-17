/**
*
* Not used yet
*
 **/

package model;

import lombok.Getter;

public class Theatre {
    @Getter private Integer theatreid;
    @Getter private String studioname;


    public Theatre() {
        theatreid = 0;
        studioname = "";
    }

    public Theatre(Integer theatreid, String studioname) {
        this.theatreid = theatreid;
        this.studioname = studioname;
    }

}
