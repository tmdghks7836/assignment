# 공급 도서 API

------------
## info

+ dependencies
  + lombok
  + jpa
  + spring-boot-starter-test
  + querydsl-jpa
  + springfox-swagger
  + h2database
  + mapstruct
  
+ URL: localhost:8080

------------

### [swagger API]

+  /swagger-ui.html

------------

### [요건]


  + 1. 발행일자가 ‘2018’ 이전 건은 ‘절판’ 상태값으로 조회되도록 한다.
  + 2. 할인율이 적용 된 할인 단가도 조회되는 필드를 추가한다.
  ```
    #판매 상태값: salesStatus (SOLD_OUT, PROCEEDING)
    #할인 단가: discountPrice
     public SupplyResponse(Supply supply,
                          BookDiscountStrategy bookDiscountStrategy,
                          BookSalesStrategy bookSalesStrategy) {


        this.supplyId = supply.getId();
        this.supplyDateTime = supply.getSupplyDateTime();
        this.books = supply.getSupplyBookMaps().stream()
                .map(supplyBookMap -> {

                    Book book = supplyBookMap.getBook();
                    long discountPrice = bookDiscountStrategy.calculation(book);
                    SalesStatus salesStatus = bookSalesStrategy.getSalesStatus(book);

                    return BookMapper.INSTANCE.entityToDetailDto(book, discountPrice, salesStatus);
                })
                .collect(Collectors.toList());
    }
     
  ```
