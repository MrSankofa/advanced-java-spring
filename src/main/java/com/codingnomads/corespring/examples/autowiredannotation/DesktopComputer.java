/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.autowiredannotation;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // we want spring to make a bean of this class
@ToString
public class DesktopComputer {
    @Autowired // then autowire a video card instance into this class.
    @Qualifier("radeon") private VideoCard videoCard;
    // we have multiple implementation of videocard so spring needs to know which video card
    // do we want wired in.
}
