package com.tools.module.app.service;


import com.tools.common.model.Result;
import com.tools.module.app.model.AppGen;

import java.util.List;

public interface AppGenService {

    Result list(AppGen gen);

    List<AppGen> getByTable(AppGen gen);
}
