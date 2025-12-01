package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new md.restaurant.app.DataBinderMapperImpl());
  }
}
