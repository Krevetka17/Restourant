package md.restaurant.app.data.remote.dto;

import com.google.gson.annotations.SerializedName;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003JU\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020#H\u00d6\u0001J\t\u0010$\u001a\u00020\u0003H\u00d6\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006%"}, d2 = {"Lmd/restaurant/app/data/remote/dto/EditProfileRequestDto;", "", "_id", "", "userId", "Lmd/restaurant/app/data/remote/dto/UserRef;", "oldData", "Lmd/restaurant/app/data/remote/dto/UserDataDto;", "newData", "status", "requestedAt", "processedAt", "(Ljava/lang/String;Lmd/restaurant/app/data/remote/dto/UserRef;Lmd/restaurant/app/data/remote/dto/UserDataDto;Lmd/restaurant/app/data/remote/dto/UserDataDto;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "get_id", "()Ljava/lang/String;", "getNewData", "()Lmd/restaurant/app/data/remote/dto/UserDataDto;", "getOldData", "getProcessedAt", "getRequestedAt", "getStatus", "getUserId", "()Lmd/restaurant/app/data/remote/dto/UserRef;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"})
public final class EditProfileRequestDto {
    @com.google.gson.annotations.SerializedName(value = "_id")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String _id = null;
    @org.jetbrains.annotations.Nullable()
    private final md.restaurant.app.data.remote.dto.UserRef userId = null;
    @org.jetbrains.annotations.NotNull()
    private final md.restaurant.app.data.remote.dto.UserDataDto oldData = null;
    @org.jetbrains.annotations.NotNull()
    private final md.restaurant.app.data.remote.dto.UserDataDto newData = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String status = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String requestedAt = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String processedAt = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final md.restaurant.app.data.remote.dto.UserRef component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final md.restaurant.app.data.remote.dto.UserDataDto component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final md.restaurant.app.data.remote.dto.UserDataDto component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final md.restaurant.app.data.remote.dto.EditProfileRequestDto copy(@org.jetbrains.annotations.Nullable()
    java.lang.String _id, @org.jetbrains.annotations.Nullable()
    md.restaurant.app.data.remote.dto.UserRef userId, @org.jetbrains.annotations.NotNull()
    md.restaurant.app.data.remote.dto.UserDataDto oldData, @org.jetbrains.annotations.NotNull()
    md.restaurant.app.data.remote.dto.UserDataDto newData, @org.jetbrains.annotations.NotNull()
    java.lang.String status, @org.jetbrains.annotations.NotNull()
    java.lang.String requestedAt, @org.jetbrains.annotations.Nullable()
    java.lang.String processedAt) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
    
    public EditProfileRequestDto(@org.jetbrains.annotations.Nullable()
    java.lang.String _id, @org.jetbrains.annotations.Nullable()
    md.restaurant.app.data.remote.dto.UserRef userId, @org.jetbrains.annotations.NotNull()
    md.restaurant.app.data.remote.dto.UserDataDto oldData, @org.jetbrains.annotations.NotNull()
    md.restaurant.app.data.remote.dto.UserDataDto newData, @org.jetbrains.annotations.NotNull()
    java.lang.String status, @org.jetbrains.annotations.NotNull()
    java.lang.String requestedAt, @org.jetbrains.annotations.Nullable()
    java.lang.String processedAt) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String get_id() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final md.restaurant.app.data.remote.dto.UserRef getUserId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final md.restaurant.app.data.remote.dto.UserDataDto getOldData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final md.restaurant.app.data.remote.dto.UserDataDto getNewData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRequestedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getProcessedAt() {
        return null;
    }
}