package com.aws.soccer.common.service.impl;

import com.aws.soccer.common.model.PageDTO;
import com.aws.soccer.common.service.PageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PageServiceImpl implements PageService {


    public PageDTO getPageDTO(Long totalCount, int pageSize, int pageNum){

        long BLOCK_SIZE = 10;
        long blockNum = 1;

        Long pageCount = (totalCount % pageSize == 0) ? totalCount / pageSize : totalCount / pageSize + 1;
        Long blockCount = (pageCount % BLOCK_SIZE == 0) ? pageCount / BLOCK_SIZE : pageCount / BLOCK_SIZE + 1;

        Long startRow = (long) (pageNum - 1) * pageSize;
        Long endRow = (((pageNum - 1) * pageSize + pageSize - 1) > totalCount) ? totalCount : (pageNum - 1) * pageSize + (pageSize - 1);

        Long startPage = (blockNum - 1) * BLOCK_SIZE + 1;
        Long endPage = ((blockNum - 1) * BLOCK_SIZE + 1 + (BLOCK_SIZE - 1) > pageCount) ? pageCount : (blockNum - 1) * BLOCK_SIZE + 1 + (BLOCK_SIZE - 1);

        Boolean existPrev = (blockNum != 1) ? true : false;
        Boolean existNext = (blockNum != (blockCount)) ? true : false;

        Long prevBlock = blockNum - 1;
        Long nextBlock = blockNum + 1;

        return PageDTO.builder()
                .totalCount(totalCount)
                .pageCount(pageCount)
                .blockCount(blockCount)
                .startRow(startRow)
                .endRow(endRow)
                .startPage(startPage)
                .endPage(endPage)
                .existPrev(existPrev)
                .existNext(existNext)
                .prevBlock(prevBlock)
                .nextBlock(nextBlock)
                .build();
    }

    List<String> a = new ArrayList<>();
}
