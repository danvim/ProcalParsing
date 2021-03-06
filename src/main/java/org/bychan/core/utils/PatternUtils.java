package org.bychan.core.utils;

import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

/**
 * Created by alext on 2015-03-25.
 */
public class PatternUtils {

    public static List<String> quote( final Collection<String> strings) {
        return strings.stream().map(Pattern::quote).collect(toList());
    }
}
