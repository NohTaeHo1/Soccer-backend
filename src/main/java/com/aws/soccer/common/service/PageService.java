package com.aws.soccer.common.service;

import com.aws.soccer.common.model.PageDTO;

public interface PageService {
    PageDTO getPageDTO(long totalCount, int pageSize, int pageNum);
}
