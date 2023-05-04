import { TestBed } from '@angular/core/testing';

import { TokenProcessService } from './token-process.service';

describe('TokenProcessService', () => {
  let service: TokenProcessService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TokenProcessService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
