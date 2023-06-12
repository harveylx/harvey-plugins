package net.devious.plugins.animated.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ArmourType
{
    Bronze(1155, 1117, 1075),
    Iron(1153, 1115, 1067),
    Steel(1157, 1119, 1069),
    Black(1165, 1125, 1077),
    Mithril(1159, 1121, 1071),
    Adamant(1161, 1123, 1073),
    Rune(1163, 1127, 1079);

    private final int helm;
    private final int platebody;
    private final int platelegs;
}
