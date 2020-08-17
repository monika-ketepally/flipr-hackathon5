import { Component, OnInit } from '@angular/core';

import { ServiceService } from '../service.service';
import { HistoricalData } from '../model';
import { Observable} from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  historicalData: Observable<HistoricalData[]>;
  single: any[]; 
  multi: any[];
select :any;
  view: any[] = [800, 360];
  todayStock :any;
  // options
  showXAxis = true;
  showYAxis = true;
  gradient = false;
  showLegend = true;
  showXAxisLabel = true;
  xAxisLabel = 'stocks';
  showYAxisLabel = true;
  yAxisLabel = 'months';
  todayStockb : any;
  todayStockn : any;
  choose : any;
  colorScheme = {
    domain: ['#007acc', '#A10A28', '#C7B42C', '#AAAAAA']
  };
  constructor(private service : ServiceService) { 
    this.todayStockn = {date :'',adjClose :'',close:'',high:'',open:'',volume:''};
    this.todayStockb = {date :'',adjClose :'',close:'',high:'',open:'',volume:''};
    this.todayStock = {date :'',adjClose :'',close:'',high:'',open:'',volume:''};
    this.historicalData= this.service.historicalData;
    this.single = this.service.getStaticData();
  }

  ngOnInit(): void {
    this.service.NSE().subscribe((result:any)=>{
      this.todayStock = result;
      this.todayStockn = result;
      console.log(result)});
      this.service.BSE().subscribe((result:any)=>{
        this.todayStockb = result;
        console.log(result)});
  }
  public onSelect(event): void {

  }

  public onRefresh(): void {
    
  }

  choosee():any{
    if(this.choose === 'BSE'){
      this.todayStock = this.todayStockb;
    }
    else{
      this.todayStock = this.todayStockn;
    }
  }  
}
